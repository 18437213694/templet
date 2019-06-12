package com.reactx.selection.service.reactx.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.baomidou.mybatisplus.plugins.Page;
import com.reactx.selection.models.base.Result;
import com.reactx.selection.models.data.request.CreateClickUrlRequest;
import com.reactx.selection.models.data.taobao.query.PageQuery;
import com.reactx.selection.models.data.taobao.response.MapData;
import com.reactx.selection.service.reactx.MaterialService;
import com.reactx.selection.service.reactx.TaobaoCodeDecodeService;
import com.taobao.api.ApiException;
import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import com.taobao.api.request.TbkItemInfoGetRequest;
import com.taobao.api.request.TbkTpwdConvertRequest;
import com.taobao.api.response.TbkDgMaterialOptionalResponse;
import com.taobao.api.response.TbkItemInfoGetResponse;
import com.taobao.api.response.TbkTpwdConvertResponse;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TaobaoCodeDecodeServiceImpl extends BaseTaobaoServiceImpl implements TaobaoCodeDecodeService {


	private static final Logger logger = LoggerFactory.getLogger(TaobaoCodeDecodeServiceImpl.class);

	private static String appurl = "http://gw.api.taobao.com/router/rest";
	private static String appKey = "25327447";
	private static String appSecret = "6fdc222ab2dfb74ff308b961c991be71";

	@Autowired
	MaterialService materialService;


	@Override
	public Result<Page<MapData>> getData(PageQuery query) {
		String keyword = query.getKeyword();
//		String url = String.format("%s%s%s%s", "http://api.vephp.com/dec?vekey=V00000963Y49141262&para=", "￥",
//				keyword.split("￥")[1], "￥");
//		String title = query.getKeyword().replace("【", "").split("】")[0];
//		ResponseEntity<String> response = this.restTemplate.getForEntity(url, String.class);
//		System.err.println(response.getBody());
//		TaobaoCodeDecodeResponse rsp = JSON.parseObject(response.getBody(), TaobaoCodeDecodeResponse.class);
//		if (rsp.getError() != null && !rsp.getMsg().equals("产品已下架或非联盟产品"))
//			ExceptionFactory.build(rsp.getMsg());
//		if (rsp.getMsg() != null && rsp.getMsg().equals("产品已下架或非联盟产品")) {
//			query.setKeyword(title);
//			String json = taobaoService.findMaterialPage(query);
//			Result<Page<MapData>> result = JSON.parseObject(json, new TypeReference<Result<Page<MapData>>>() {
//			});
//			return result;
//		}

		//使用淘宝客接口解析淘口令
		String tkl ="￥"+keyword.split("￥")[1]+"￥";
		String itemUrl = "";
		try {
			TaobaoClient client = new DefaultTaobaoClient(appurl, appKey, appSecret);
			TbkTpwdConvertRequest req = new TbkTpwdConvertRequest();
			req.setPasswordContent(tkl);
			req.setAdzoneId(65231850041L);
			TbkTpwdConvertResponse rsp = client.execute(req);
			System.out.println(rsp.getBody());
			JSONObject jsonObject = JSON.parseObject(rsp.getBody());
			String num_iid = jsonObject.getJSONObject("tbk_tpwd_convert_response").getJSONObject("data").getString("num_iid");

			String itemInfo = getItemInfo(num_iid, query.getIp());
			JSONObject itemInfoJson = JSON.parseObject(itemInfo);
			JSONArray data = itemInfoJson.getJSONArray("data");
			itemUrl = data.getJSONObject(0).get("itemUrl").toString();
			System.out.println(itemInfo);
		}catch (Exception e){
			logger.error("淘宝客解析淘口令出错:"+e.getMessage()+"  itemUrl:"+itemUrl);
		}


		query.setKeyword(itemUrl);
		return JSON.parseObject(findPage(query), new TypeReference<Result<Page<MapData>>>() {
		});
	}

	@Override
	public String createClickUrl(CreateClickUrlRequest request) {
		return null;
	}

	private String getItemInfo( String itemId,  String ip) {
		try {
			if (StringUtils.isBlank(itemId)) {
				return new Result<Object>("501","id不能为空").toString();
			}
			return new Result<Object>("200","ok",getItemInfo2(itemId, ip)).toString();
		} catch (ApiException e) {
			e.printStackTrace();
			return new Result<Object>("501","false",e.getMessage()).toString();
		}
	}

	private List<TbkItemInfoGetResponse.NTbkItem> getItemInfo2(String itemId, String ip) throws ApiException {
		TaobaoClient client = getClient();
		TbkItemInfoGetRequest req = new TbkItemInfoGetRequest();
		req.setNumIids(itemId);
		req.setPlatform(2L);
		req.setIp(ip);
		TbkItemInfoGetResponse rsp = client.execute(req);
		logger.debug("获取商品详情，请求参数：itemId-{};ip-{}，返回参数：{}", itemId, ip, rsp);
		List<TbkItemInfoGetResponse.NTbkItem> list = rsp.getResults();
		return list;
	}

	private String findPage(PageQuery query) {

		try {
			if (StringUtils.isBlank(query.getKeyword()))
//				return response(new Page<MapData>(new ArrayList<>(),0L,1L, 10L));
				return new Result<Object>("501","您粘贴的内容非淘宝联盟商品").toString();
			if (StringUtils.isNotBlank(query.getOrderByField()) && query.getIsAsc() == null)
				return new Result<Object>("501","排序列存在则排序方式必须存在").toString();
			com.reactx.selection.models.base.page.Page<TbkDgMaterialOptionalResponse.MapData> page = materialService.getPage(query);
			return new Result<Object>("200","ok",page).toString();
		} catch (ApiException e) {
			e.printStackTrace();
			return new Result<Object>("501","false",e.getMessage()).toString();
		}
	}

}

package com.reactx.selection.web.controller.reactx;

import com.reactx.selection.models.base.BaseController;
import com.reactx.selection.models.base.Result;
import com.reactx.selection.models.base.page.Page;
import com.reactx.selection.models.base.util.CusAccessObjectUtil;
import com.reactx.selection.models.data.taobao.query.OptimusMaterialQuery;
import com.reactx.selection.models.data.taobao.query.PageQuery;
import com.reactx.selection.models.data.taobao.request.CreateTbkTpwdRequest;
import com.reactx.selection.service.reactx.MaterialService;
import com.reactx.selection.service.reactx.TaobaoCodeDecodeService;
import com.taobao.api.ApiException;
import com.taobao.api.response.TbkDgMaterialOptionalResponse.MapData;
import com.taobao.api.response.TbkItemInfoGetResponse.NTbkItem;
import io.swagger.annotations.*;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/taobao")
@Api(value = "taobao", description = "淘宝相关")
public class TaobaoController extends BaseController {

	@Autowired
	private MaterialService materialService;

	@Autowired
	private TaobaoCodeDecodeService taobaoCodeDecodeService;

	@GetMapping("/findPageByKeyword")
	@ApiOperation(value = "关键字分页搜索-http://open.taobao.com/api.htm?docId=35896&docType=2", httpMethod = "GET", produces = "application/json;charset=UTF-8")
	@ApiImplicitParams({ @ApiImplicitParam(name = "pageNo", value = "当前页", paramType = "query", required = false),
			@ApiImplicitParam(name = "pageSize", value = "分页大小", paramType = "query", required = false),
			@ApiImplicitParam(name = "orderByField", value = "排序列(不需要则为null)销量（total_sales），淘客佣金比率（tk_rate）， 累计推广量（tk_total_sales），总支出佣金（tk_total_commi），价格（price）", paramType = "query", required = false),
			@ApiImplicitParam(name = "isAsc", value = "排序方式(排序列存在则排序方式必须存在)true,false", paramType = "query", required = false),
			@ApiImplicitParam(name = "keyword", value = "关键字", paramType = "query", required = true),
			@ApiImplicitParam(name = "endPrice", value = "折扣价范围上限，单位：元", paramType = "query", required = false),
			@ApiImplicitParam(name = "startPrice", value = "折扣价范围下限，单位：元", paramType = "query", required = false)})
	@ApiResponse(code = 200, message = "Ok", response = Result.class)
	public Result<Object> findPageByKeyword(PageQuery query, HttpServletRequest request) {
//		if (LongUtil.isBlank(query.getUserId()) && StringUtils.isBlank(query.getOpenId()))
//			return JSON.toJSONString(responseMsg("用户id和openid不能同时不能为空"));
//		ImsSeller seller;
//		if (LongUtil.isNotBlank(query.getUserId()))
//			seller = sellerService.selectById(query.getUserId());
//		else
//			seller = sellerService.findByWechatid(query.getWechatid());
//		ImsSeller seller = sellerService.find(query.getUnionid());
//		if (seller == null)
//			return JSON.toJSONString(responseMsg("用户不存在"));
//		if (StringUtils.isBlank(seller.getAdzoneid()))
//			return JSON.toJSONString(responseMsg("用户的推广位id为空"));
		query.setAdzoneId(Long.parseLong("65231850041"));
		query.setIp(CusAccessObjectUtil.getIpAddress(request));
		if (StringUtils.isBlank(query.getKeyword()))
			return responseMsg("关键字不能为空");
		if (StringUtils.contains(query.getKeyword(), "$")){
			String replace = query.getKeyword().replace("$", "￥");
			query.setKeyword(replace);
		}
		if (StringUtils.contains(query.getKeyword(), "￥"))
			return response(taobaoCodeDecodeService.getData(query));
		if (StringUtils.contains(query.getKeyword(), "【") && StringUtils.contains(query.getKeyword(), "】"))
			query.setKeyword(query.getKeyword().replace("【", "").split("】")[0]);
		return findPage(query);
	}

	private Result<Object> findPage(PageQuery query) {

		try {
			if (StringUtils.isBlank(query.getKeyword()))
//				return response(new Page<MapData>(new ArrayList<>(),0L,1L, 10L));
				return responseMsg("您粘贴的内容非淘宝联盟商品");
			if (StringUtils.isNotBlank(query.getOrderByField()) && query.getIsAsc() == null)
				return responseMsg("排序列存在则排序方式必须存在");
			Page<MapData> page = materialService.getPage(query);
			return response(page);
		} catch (ApiException e) {
			e.printStackTrace();
			return responseMsg(e.getMessage());
		}
	}



	@GetMapping("/getItemInfo")
	@ApiOperation(value = "获取商品详情", httpMethod = "GET", produces = "application/json;charset=UTF-8")
	@ApiImplicitParams(@ApiImplicitParam(name = "itemId", value = "商品id", paramType = "query", required = true))
	public Result<Object> getItemInfo(@RequestParam("itemId") String itemId, @RequestParam("ip") String ip) {
		try {
			if (StringUtils.isBlank(itemId)) {
				return responseMsg("id不能为空");
			}
			return response(materialService.getItemInfo(itemId, ip));
		} catch (ApiException e) {
			e.printStackTrace();
			return responseMsg(e.getMessage());
		}
	}

	@GetMapping("/getItemPic")
	@ApiOperation(value = "获取商品图片", httpMethod = "GET", produces = "application/json;charset=UTF-8")
	@ApiImplicitParams(@ApiImplicitParam(name = "itemId", value = "商品id", paramType = "query", required = true))
	public String getItemPic(@RequestParam("itemId") String itemId) {
		try {
			List<NTbkItem> list = materialService.getItemInfo(itemId, "");
			return list.get(0).getPictUrl();
		} catch (ApiException e) {
			e.printStackTrace();
			return e.getMessage();
		}
	}

	@PostMapping("/createTbkTpwd")
	@ApiOperation(value = "创建淘口令", httpMethod = "POST", produces = "application/json;charset=UTF-8")
	@ApiImplicitParams({ @ApiImplicitParam(name = "text", value = "口令弹框内容", paramType = "query", required = true),
			@ApiImplicitParam(name = "url", value = "口令跳转目标页", paramType = "query", required = true),
			@ApiImplicitParam(name = "logo", value = "口令弹框logoURL", paramType = "query", required = false) })
	@ApiResponse(code = 200, message = "Ok", response = Result.class)
	public Result<Object> createTbkTpwd(@RequestBody CreateTbkTpwdRequest request) {
		try {
			if (StringUtils.isBlank(request.getText())) {
				return responseMsg("内容不能为空");
			}
			if (request.getText().length() < 5) {
				return responseMsg("内容长度必须大于5个字符");
			}
			if (StringUtils.isBlank(request.getUrl())) {
				return responseMsg("内容不能为空");
			}
			return materialService.createTbkTpwd(request);
		} catch (ApiException e) {
			e.printStackTrace();
			return responseMsg(e.getMessage());
		}
	}

	/**
	 * 淘宝客物料下行分页查询
	 * 
	 * @param query
	 * @return
	 */
	@PostMapping("/optimusMaterialPage")
	public Result<Object> optimusMaterialPage(@RequestBody OptimusMaterialQuery query) {
		try {
			return response(materialService.optimusMaterialPage(query));
		} catch (ApiException e) {
			e.printStackTrace();
			return responseMsg(e.getMessage());
		}
	}

}

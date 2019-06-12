package com.reactx.selection.service.reactx.impl;

import com.alibaba.fastjson.JSON;
import com.reactx.selection.models.base.Result;
import com.reactx.selection.models.base.page.Page;
import com.reactx.selection.models.base.util.ResponseUtil;
import com.reactx.selection.models.data.taobao.query.OptimusMaterialQuery;
import com.reactx.selection.models.data.taobao.query.PageQuery;
import com.reactx.selection.models.data.taobao.request.CreateTbkTpwdRequest;
import com.reactx.selection.service.reactx.MaterialService;
import com.taobao.api.ApiException;
import com.taobao.api.TaobaoClient;
import com.taobao.api.request.TbkDgMaterialOptionalRequest;
import com.taobao.api.request.TbkDgOptimusMaterialRequest;
import com.taobao.api.request.TbkItemInfoGetRequest;
import com.taobao.api.request.TbkTpwdCreateRequest;
import com.taobao.api.response.TbkDgMaterialOptionalResponse;
import com.taobao.api.response.TbkDgMaterialOptionalResponse.MapData;
import com.taobao.api.response.TbkDgOptimusMaterialResponse;
import com.taobao.api.response.TbkItemInfoGetResponse;
import com.taobao.api.response.TbkItemInfoGetResponse.NTbkItem;
import com.taobao.api.response.TbkTpwdCreateResponse;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MaterialServiceImpl extends BaseTaobaoServiceImpl implements MaterialService {

	private static final Logger logger = LoggerFactory.getLogger(MaterialServiceImpl.class);

	@Override
	public Page<MapData> getPage(PageQuery query) throws ApiException {

		TaobaoClient client = getClient();
		TbkDgMaterialOptionalRequest req = new TbkDgMaterialOptionalRequest();
		req.setPageSize(query.getPageSize());
		req.setPageNo(query.getPageNo());
		req.setPlatform(2L);
		if (StringUtils.isNotBlank(query.getOrderByField()))
			req.setSort(query.getOrderByField() + (query.getIsAsc() ? "_asc" : "_des"));
		req.setQ(query.getKeyword());
		Double endPrice = 9999.99;
		req.setEndPrice(/*query.getEndPrice()*/endPrice.longValue());
		req.setStartPrice(query.getStartPrice());
		req.setNeedFreeShipment(query.getNeedFreeShipment());
		req.setMaterialId(/*6707L*/2836L);
		req.setHasCoupon(false);
		req.setIp(query.getIp());
		req.setAdzoneId(/*query.getAdzoneId()*/65231850041L);
		TbkDgMaterialOptionalResponse rsp = client.execute(req);
		logger.debug("通用物料搜索API（导购），请求参数：{}，返回参数：{}", query, JSON.toJSONString(rsp));
		List<MapData> resultList = rsp.getResultList();
		if (resultList == null)
			resultList = new ArrayList<MapData>();
		return new Page<MapData>(resultList, rsp.getTotalResults() == null ? 0 : rsp.getTotalResults(),
				query.getPageSize(), query.getPageNo());
	}

	@Override
	public List<NTbkItem> getItemInfo(String itemId, String ip) throws ApiException {
		TaobaoClient client = getClient();
		TbkItemInfoGetRequest req = new TbkItemInfoGetRequest();
		req.setNumIids(itemId);
		req.setPlatform(2L);
		req.setIp(ip);
		TbkItemInfoGetResponse rsp = client.execute(req);
		logger.debug("获取商品详情，请求参数：itemId-{};ip-{}，返回参数：{}", itemId, ip, rsp);
		List<NTbkItem> list = rsp.getResults();
		return list;
	}

	@Override
	public Result<Object> createTbkTpwd(CreateTbkTpwdRequest request) throws ApiException {

		TaobaoClient client = getClient();
		TbkTpwdCreateRequest req = new TbkTpwdCreateRequest();
		req.setText(request.getText());
		req.setUrl(request.getUrl() + "&relationId=" + request.getRelationId());
		System.out.println(req.getUrl());
		req.setLogo(request.getLogo());
		TbkTpwdCreateResponse rsp = client.execute(req);
		System.out.println(rsp.getData());
		logger.debug("创建淘口令，请求参数：{}，返回参数：{}", request, JSON.toJSONString(rsp));
		com.taobao.api.response.TbkTpwdCreateResponse.MapData data = rsp.getData();
		if (data == null)
			return ResponseUtil.getParamErrorResult(rsp.getSubMsg());
		return ResponseUtil.getSuccessResult(data.getModel());
	}

	@Override
	public Page<com.taobao.api.response.TbkDgOptimusMaterialResponse.MapData> optimusMaterialPage(
			OptimusMaterialQuery query) throws ApiException {
		TaobaoClient client = getClient();
		TbkDgOptimusMaterialRequest req = new TbkDgOptimusMaterialRequest();
		req.setPageSize(query.getPageSize());
		req.setAdzoneId(/*query.getAdzoneId()*/65231850041L);
		req.setPageNo(query.getPageNo());
//		req.setMaterialId(6708L);
		req.setMaterialId(3756L);
		req.setDeviceValue(query.getDeviceValue());
		req.setDeviceEncrypt("MD5");
		req.setDeviceType(query.getDeviceType());
		TbkDgOptimusMaterialResponse rsp = client.execute(req);
		logger.debug("通用物料搜索API（导购），请求参数：{}，返回参数：{}", query, JSON.toJSONString(rsp));
		List<TbkDgOptimusMaterialResponse.MapData> list = rsp.getResultList();
		return new Page<com.taobao.api.response.TbkDgOptimusMaterialResponse.MapData>(list, 0L, query.getPageSize(),
				query.getPageNo());
	}

}

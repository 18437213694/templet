package com.reactx.selection.service.reactx.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.baomidou.mybatisplus.plugins.Page;
import com.reactx.selection.configs.PddConfig;
import com.reactx.selection.configs.redis.RedisRepository;
import com.reactx.selection.models.base.exceptions.ExceptionFactory;
import com.reactx.selection.models.data.pinduoduo.base.BasePddRequest;
import com.reactx.selection.models.data.pinduoduo.base.BasePddResponse;
import com.reactx.selection.models.data.pinduoduo.query.PddGoodsQuery;
import com.reactx.selection.models.data.pinduoduo.request.PddDdkGoodsSearchRequest;
import com.reactx.selection.models.data.pinduoduo.response.ErrorResponse;
import com.reactx.selection.models.data.pinduoduo.response.Goods;
import com.reactx.selection.models.data.pinduoduo.util.PopClientUtil;
import com.reactx.selection.service.reactx.PddService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PddServiceImpl implements PddService {

	private String goodsSearch = "pdd.ddk.goods.search";

	@Autowired
	private RedisRepository redisRepository;

	@Autowired
	private PddConfig config;
	@Autowired
	private RestTemplate restTemplate;

	private static final Logger logger = LoggerFactory.getLogger(PddServiceImpl.class);

	@Override
	public Page<Goods> findPage(PddGoodsQuery query){
		try {
			String value = redisRepository.get(String.format("pdd:goods_%s", JSON.toJSONString(query)));
			if (StringUtils.isNotBlank(value))
				return JSON.parseObject(value, new TypeReference<Page<Goods>>() {
				});
			PddDdkGoodsSearchRequest request = new PddDdkGoodsSearchRequest();

			request.setSort_type(query.getSortType());
			request.setCat_id(query.getCatId());
			request.setMerchant_type(query.getMerchantType());
			request.setKeyword(query.getKeyword());
			request.setPage(query.getPageNo());
			request.setPage_size(query.getPageSize());
			//request.setWith_coupon(true);
			if (StringUtils.isNotBlank(query.getGoodsId()))
				request.setGoods_id_list(String.format("[%s]", query.getGoodsId()));
			BasePddResponse response = syncInvoke(request, goodsSearch);
			Page<Goods> page = query.getPage();
			page.setTotal(response.getGoods_search_response().getTotal_count());
			page.setRecords(response.getGoods_search_response().getGoods_list());
			redisRepository.setExpire(String.format("pdd:goods_%s", JSON.toJSONString(query)), JSON.toJSONString(page),
					60 * 10L);
			return page;
		}catch (Exception e){
			logger.error("获取拼多多商品出错:"+e.getMessage());
		}
		return null;
	}

	private BasePddResponse syncInvoke(BasePddRequest request, String type) throws Exception {
		request.setClient_id(config.getClientId());
		request.setType(type);
		request.setTimestamp(System.currentTimeMillis() / 1000 + "");
		request.setSign(PopClientUtil.getSign(request, config.getClientSecret()));
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
		HttpEntity<BasePddRequest> entity = new HttpEntity<BasePddRequest>(request, headers);
		ResponseEntity<String> result = restTemplate.exchange(config.getUrl(), HttpMethod.POST, entity, String.class);
		System.err.println(JSON.toJSONString(result));
		BasePddResponse response = JSON.parseObject(result.getBody(), BasePddResponse.class);
		ErrorResponse error = response.getError_response();
		if (error != null) {
			ExceptionFactory.build(error.getError_msg());
		}
		return response;
	}
}

package com.reactx.selection.service.reactx.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.baomidou.mybatisplus.plugins.Page;
import com.reactx.selection.configs.PddConfig;
import com.reactx.selection.configs.redis.RedisRepository;
import com.reactx.selection.models.base.exceptions.ExceptionFactory;
import com.reactx.selection.models.data.jingdong.query.JdGoodsQuery;
import com.reactx.selection.models.data.jingdong.response.JdGoods;
import com.reactx.selection.models.data.jingdong.response.JdResult;
import com.reactx.selection.models.data.pinduoduo.base.BasePddRequest;
import com.reactx.selection.models.data.pinduoduo.base.BasePddResponse;
import com.reactx.selection.models.data.pinduoduo.query.PddGoodsQuery;
import com.reactx.selection.models.data.pinduoduo.request.PddDdkGoodsSearchRequest;
import com.reactx.selection.models.data.pinduoduo.response.ErrorResponse;
import com.reactx.selection.models.data.pinduoduo.response.Goods;
import com.reactx.selection.models.data.pinduoduo.util.PopClientUtil;
import com.reactx.selection.service.reactx.JdService;
import com.reactx.selection.service.reactx.PddService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class JdServiceImpl implements JdService {

	@Autowired
	private RestTemplate restTemplate;
	@Autowired
	private RedisRepository redisRepository;

	private static final Logger logger = LoggerFactory.getLogger(JdServiceImpl.class);

	@Override
	public Page<JdGoods> findPage(JdGoodsQuery query) {
		String value = redisRepository.get(String.format("jd:goods_%s", JSON.toJSONString(query)));
		if (StringUtils.isNotBlank(value))
			return JSON.parseObject(value, new TypeReference<Page<JdGoods>>() {
			});
		Page<JdGoods> page = query.getPage();
		StringBuilder b = new StringBuilder();
		//b.append("http://jdapi.vephp.com/conponitems?");
		b.append("http://api.josapi.net/conponitems?");
//		b.append(String.format("page=%s", page.getCurrent()));
//		b.append(String.format("&pagesize=%s", page.getSize()));
		b.append(String.format("page=%s", query.getPageNo()));
		b.append(String.format("&pagesize=%s", query.getPageSize()));
		if (StringUtils.isNotBlank(query.getKeyword()))
			b.append(String.format("&keyword=%s", query.getKeyword()));
		if (StringUtils.isNotBlank(query.getPricefrom()))
			b.append(String.format("&pricefrom=%s", query.getPricefrom()));
		if (StringUtils.isNotBlank(query.getPriceto()))
			b.append(String.format("&priceto=%s", query.getPriceto()));
		ResponseEntity<String> response = restTemplate.getForEntity(b.toString(), String.class);
		logger.debug("京东商品接口-请求：{}，返回{}", b.toString(), response.getBody());
		JdResult<List<JdGoods>> result = JSON.parseObject(response.getBody(),
				new TypeReference<JdResult<List<JdGoods>>>() {
				});
		if (result.getError() != 0)
			ExceptionFactory.build(result.getMsg());
		page.setTotal(result.getTotal());
		page.setRecords(result.getData());
		redisRepository.setExpire(String.format("jd:goods_%s", JSON.toJSONString(query)), JSON.toJSONString(page),
				60 * 10L);
		return page;
	}
}

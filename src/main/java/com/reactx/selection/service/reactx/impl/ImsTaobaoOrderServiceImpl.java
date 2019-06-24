package com.reactx.selection.service.reactx.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.reactx.selection.configs.redis.RedisRepository;
import com.reactx.selection.mappers.ImsTaobaoOrderMapper;
import com.reactx.selection.models.base.BaseServiceImpl;
import com.reactx.selection.models.base.SysStatic;
import com.reactx.selection.models.data.index.ImsSeller;
import com.reactx.selection.models.data.index.ImsTaobaoOrder;
import com.reactx.selection.models.data.response.OrderResponse;
import com.reactx.selection.service.reactx.ImsSellerService;
import com.reactx.selection.service.reactx.ImsTaobaoOrderService;
import com.reactx.selection.service.reactx.MaterialService;
import com.taobao.api.response.TbkItemInfoGetResponse;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.*;


@Service
public class ImsTaobaoOrderServiceImpl extends BaseServiceImpl<ImsTaobaoOrderMapper, ImsTaobaoOrder>
		implements ImsTaobaoOrderService {

	private static final Logger logger = LoggerFactory.getLogger(ImsTaobaoOrderServiceImpl.class);

	@Autowired
	private MaterialService materialService;
	@Autowired
	private ImsSellerService sellerService;
	@Autowired
	private RedisRepository redisRepository;

	@Override
	public List<OrderResponse> getOrderByUser(Long userId,Double commRatio) {
		try {
			List<ImsTaobaoOrder> orders = baseMapper.getOrder(userId,0L,3L);
			List<OrderResponse> result = new ArrayList<>();
			Set<String> items = new HashSet<>();
			for(ImsTaobaoOrder o:orders){
				OrderResponse order = new OrderResponse();
				order.setCreateTime(o.getCreateTime());
				order.setIssettle(o.getIssettle());
				order.setOrderNum(o.getOrdersn());
				order.setPayMoney(o.getPrice());
				order.setPlatform(o.getPlatform());
				order.setOrderstatus(o.getOrderstatus());

				//设置约返
				DecimalFormat decimalFormat = new DecimalFormat("####.00");
				decimalFormat.setRoundingMode(RoundingMode.DOWN);
				String format = decimalFormat.format(o.getEstimatecome().multiply(new BigDecimal(commRatio)));
				if(format.startsWith(".")){
					format="0"+format;
				}
				order.setEstimateMoney(format);

				order.setNumiid(o.getGoodsid());

				String value = redisRepository.get(SysStatic.ITEM_CATEGORY_KEY_ID_ + o.getGoodsid());
				if(StringUtils.isNotBlank(value)){
					order.setCategory(value.split(",")[0]);
				}else {
					items.add(o.getGoodsid());
				}
				result.add(order);
			}
			if(items.size() > 0) {
				Map<String, String> cates = materialService.getItemCategory(items, "");
				for (OrderResponse orderResponse : result) {
					if (StringUtils.isBlank(orderResponse.getCategory())) {
						orderResponse.setCategory(cates.get(orderResponse.getNumiid()));
					}
				}
			}
			return result;
		}catch (Exception e){
			logger.error("用户订单接口调用出错:"+e.getMessage());
		}


		return null;
	}

	@Override
	public Long getOrderSum(Long userId) {
		return baseMapper.getOrderSum(userId);
	}

	@Override
	public BigDecimal getPrice(Long userId) {
		return baseMapper.getPrice(userId);
	}


	@Override
	public Map<String,Object> getOrderListByUser(Long userId, Double commRatio, String startTime, String endTime,
												  String status, String source, String orderNum,Integer pageSize,Integer pageNo) {

		try {
			Map<String,Object> map = new HashMap<>();
			List<ImsTaobaoOrder> orders = baseMapper.getOrderListByUser(userId, startTime, endTime, status, source, orderNum,pageSize,pageNo);
			Integer sum = baseMapper.getOrderListByUserSum(userId, startTime, endTime, status, source, orderNum);
			map.put("total",sum);
			List<OrderResponse> result = new ArrayList<>();
			Set<String> items = new HashSet<>();
			for(ImsTaobaoOrder o:orders){
				OrderResponse order = new OrderResponse();
				order.setCreateTime(o.getCreateTime());
				order.setIssettle(o.getIssettle());
				order.setOrderNum(o.getOrdersn());
				order.setPayMoney(o.getPrice());
				order.setPlatform(o.getPlatform());
				order.setOrderstatus(o.getOrderstatus());
				//设置约返

				DecimalFormat decimalFormat = new DecimalFormat("####.00");
				decimalFormat.setRoundingMode(RoundingMode.DOWN);
				String format = decimalFormat.format(o.getEstimatecome().multiply(new BigDecimal(commRatio)));
				if(format.startsWith(".")){
					format="0"+format;
				}
				order.setEstimateMoney(format);
				order.setNumiid(o.getGoodsid());

				String value = redisRepository.get(SysStatic.ITEM_CATEGORY_KEY_ID_ + o.getGoodsid());
				if(StringUtils.isNotBlank(value)){
					order.setCategory(value.split(",")[0]);
				}else {
					items.add(o.getGoodsid());
				}

				result.add(order);
			}
			if(items.size() > 0) {
				Map<String, String> cates = materialService.getItemCategory(items, "");
				for (OrderResponse orderResponse : result) {
					if (StringUtils.isBlank(orderResponse.getCategory())) {
						orderResponse.setCategory(cates.get(orderResponse.getNumiid()));
					}
				}
			}
			map.put("orders",result);
			return map;
	}catch (Exception e){
		logger.error("用户订单接口调用出错:"+e.getMessage());
	}
		return null;
	}

	@Override
	public Map<String,Object> getOrderListByGroup(List<String> ids, Map<String,Double> map,String startTime, String endTime, String status,
												   String source, String orderNum, Integer pageSize, Integer pageNo) {
		try {
			Map<String,Object> resultMap = new HashMap<>();
			List<ImsTaobaoOrder> orders = baseMapper.getOrderListByGroup(ids, startTime, endTime, status, source, orderNum,pageSize,pageNo);
			Integer sum = baseMapper.getOrderListByGroupSum(ids, startTime, endTime, status, source, orderNum);
			resultMap.put("total",sum);
			List<OrderResponse> result = new ArrayList<>();
			Set<String> items = new HashSet<>();
			for(ImsTaobaoOrder o:orders){
				OrderResponse order = new OrderResponse();
				order.setCreateTime(o.getCreateTime());
				order.setIssettle(o.getIssettle());
				order.setOrderNum(o.getOrdersn());
				order.setPayMoney(o.getPrice());
				order.setPlatform(o.getPlatform());
				order.setOrderstatus(o.getOrderstatus());
				order.setNick(sellerService.findNickById(o.getSellerid()));
				//设置约返
				DecimalFormat decimalFormat = new DecimalFormat("####.00");
				decimalFormat.setRoundingMode(RoundingMode.DOWN);
				String format = decimalFormat.format(o.getEstimatecome().multiply(new BigDecimal(map.get(o.getSellerid().toString()))));
				if(format.startsWith(".")){
					format="0"+format;
				}
				order.setEstimateMoney(format);
				order.setNumiid(o.getGoodsid());
				String value = redisRepository.get(SysStatic.ITEM_CATEGORY_KEY_ID_ + o.getGoodsid());
				if(StringUtils.isNotBlank(value)){
					order.setCategory(value.split(",")[0]);
				}else {
					items.add(o.getGoodsid());
				}

				result.add(order);
			}
			if(items.size() > 0) {
				Map<String, String> cates = materialService.getItemCategory(items, "");
				for (OrderResponse orderResponse : result) {
					if (StringUtils.isBlank(orderResponse.getCategory())) {
						orderResponse.setCategory(cates.get(orderResponse.getNumiid()));
					}
				}
			}
			resultMap.put("orders",result);
			return resultMap;
		}catch (Exception e){
			logger.error("群资料查询订单出错:"+e.getMessage());
		}
		return null;
	}

}

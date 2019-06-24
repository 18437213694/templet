package com.reactx.selection.service.reactx;

import com.reactx.selection.models.base.BaseService;
import com.reactx.selection.models.data.index.ImsTaobaoOrder;
import com.reactx.selection.models.data.response.OrderResponse;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public interface ImsTaobaoOrderService extends BaseService<ImsTaobaoOrder> {

	List<OrderResponse> getOrderByUser(Long userId,Double commRatio);

	Long getOrderSum(Long userId);

	BigDecimal getPrice(Long userId);

	Map<String,Object> getOrderListByUser(Long userId,Double commRatio,String startTime,String endTime,
										   String status,String source,String orderNum,Integer pageSize,Integer pageNo);

	Map<String,Object> getOrderListByGroup(List<String> ids, Map<String,Double> map,String startTime, String endTime,
											String status, String source, String orderNum, Integer pageSize, Integer pageNo);
}

package com.reactx.selection.mappers;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.reactx.selection.models.base.util.IntegerUtil;
import com.reactx.selection.models.data.index.ImsTaobaoOrder;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.math.BigDecimal;
import java.util.List;

public interface ImsTaobaoOrderMapper extends BaseMapper<ImsTaobaoOrder> {

	@Select("SELECT platform,goodsid,orderstatus,issettle,create_time createTime,ordersn,price,estimatecome FROM ims_taobao_order WHERE sellerid= #{userId} ORDER BY create_time DESC limit #{startLimit},#{endLimit}")
	List<ImsTaobaoOrder> getOrder(@Param("userId") Long userId,@Param("startLimit") Long startLimit,@Param("endLimit") Long endLimit);

	@Select("SELECT count(1) FROM ims_taobao_order WHERE sellerid= #{userId}")
	Long getOrderSum(@Param("userId") Long userId);

	@Select("SELECT sum(price) FROM ims_taobao_order WHERE sellerid= #{userId}")
	BigDecimal getPrice(@Param("userId") Long userId);

	List<ImsTaobaoOrder> getOrderListByUser(@Param("userId") Long userId,@Param("startTime") String startTime,@Param("endTime") String endTime,
											@Param("status") String status,@Param("source") String source,@Param("orderNum") String orderNum
											,@Param("pageSize") Integer pageSize,@Param("pageNo") Integer pageNo);

	Integer getOrderListByUserSum(@Param("userId") Long userId,@Param("startTime") String startTime,@Param("endTime") String endTime,
							   @Param("status") String status,@Param("source") String source,@Param("orderNum") String orderNum);

	List<ImsTaobaoOrder> getOrderListByGroup(@Param("ids") List<String> ids,@Param("startTime") String startTime,@Param("endTime") String endTime,
											@Param("status") String status,@Param("source") String source,@Param("orderNum") String orderNum
											,@Param("pageSize") Integer pageSize,@Param("pageNo") Integer pageNo);

	Integer getOrderListByGroupSum(@Param("ids") List<String> ids,@Param("startTime") String startTime,@Param("endTime") String endTime,
											 @Param("status") String status,@Param("source") String source,@Param("orderNum") String orderNum);
}

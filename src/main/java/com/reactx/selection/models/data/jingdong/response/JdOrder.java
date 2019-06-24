package com.reactx.selection.models.data.jingdong.response;

import com.reactx.selection.models.data.jingdong.Sku;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
public class JdOrder {

	@ApiModelProperty("订单完成时间")
	private String finishTime;
	
	@ApiModelProperty("下单设备(1:PC,2:无线)")
	private String orderEmt;
	
	@ApiModelProperty("订单ID")
	private String orderId;
	
	@ApiModelProperty("下单时间")
	private Long orderTime;
	
	@ApiModelProperty("父单ID（订单拆分后,父单的订单号）")
	private String parentId;
	
	@ApiModelProperty("结算日期（yyyyMMdd）")
	private String payMonth;
	
	@ApiModelProperty("plus会员（0：不是，1：是）")
	private String plus;
	
	@ApiModelProperty("商家ID")
	private String popId;
	
	private List<Sku> skuList;
	
	@ApiModelProperty("站长ID")
	private String unionId;
	
	private String unionUserName;
	
	@ApiModelProperty("有效码（-1：未知,2.无效-拆单,3.无效-取消,4.无效-京东帮帮主订单,5.无效-账号异常,6.无效-赠品类目不返佣,7.无效-校园订单,8.无效-企业订单,9.无效-团购订单,10.无效-开增值税专用发票订单,11.无效-乡村推广员下单,12.无效-自己推广自己下单,13.无效-违规订单,14.无效-来源与备案网址不符,15.待付款,16.已付款,17.已完成,18.已结算）；")
	private String validCode;
}

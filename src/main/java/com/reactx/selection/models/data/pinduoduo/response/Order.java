package com.reactx.selection.models.data.pinduoduo.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel("订单")
public class Order implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@ApiModelProperty("推广订单编号")
	private String order_sn;

	@ApiModelProperty("商品ID")
	private Long goods_id;

	@ApiModelProperty("商品标题")
	private String goods_name;

	@ApiModelProperty("商品缩略图")
	private String goods_thumbnail_url;

	@ApiModelProperty("购买商品的数量")
	private Long goods_quantity;

	@ApiModelProperty("订单中sku的单件价格，单位为分")
	private Long goods_price;

	@ApiModelProperty("实际支付金额，单位为分")
	private Long order_amount;

	@ApiModelProperty("推广位ID")
	private String p_id;

	@ApiModelProperty("佣金比例，千分比")
	private Long promotion_rate;

	@ApiModelProperty("佣金金额，单位为分")
	private Long promotion_amount;

	@ApiModelProperty("订单状态： -1 未支付; 0-已支付；1-已成团；2-确认收货；3-审核成功；4-审核失败（不可提现）；5-已经结算；8-非多多进宝商品（无佣金订单）")
	private Integer order_status;

	@ApiModelProperty("订单状态描述")
	private String order_status_desc;

	@ApiModelProperty("订单生成时间，UNIX时间戳")
	private Long order_create_time;

	@ApiModelProperty("支付时间")
	private Long order_pay_time;

	@ApiModelProperty("成团时间")
	private Long order_group_success_time;

	@ApiModelProperty("审核时间")
	private Long order_verify_time;

	@ApiModelProperty("最后更新时间")
	private Long order_modify_at;

}

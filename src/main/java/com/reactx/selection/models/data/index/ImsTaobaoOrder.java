package com.reactx.selection.models.data.index;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.reactx.selection.models.base.BaseModel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.util.Date;

@Data
@ApiModel("")
@TableName("ims_taobao_order")
@EqualsAndHashCode(callSuper = true)
public class ImsTaobaoOrder extends BaseModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@ApiModelProperty("主键ID")
	@TableId(type = IdType.AUTO)
	private Long id;

	@ApiModelProperty("用户的ID")
	private Long sellerid;

	@ApiModelProperty("平台  1--淘宝  2--拼多多 3--京东")
	private Integer platform;

	@ApiModelProperty("商品的ID")
	private String goodsid;

	@ApiModelProperty("商品名称")
	private String title;

	@ApiModelProperty("商品缩略图链接")
	private String itemurl;

	@ApiModelProperty("用户淘宝下单的订单号")
	private String ordersn;

	@ApiModelProperty("商品数量")
	private Integer goodsnum;

	@ApiModelProperty("商品的价格(单价)")
	private BigDecimal goodsprice;

	@ApiModelProperty("订单状态订单状态 0 订单失效 1 订单付款 2 订单结算 3 订单成功")
	private Integer orderstatus;

	@ApiModelProperty("付款金额")
	private BigDecimal price;

	@ApiModelProperty("预估收入")
	private BigDecimal estimatecome;

	@ApiModelProperty("真实的预估收入")
	private BigDecimal estimatereal;

	@ApiModelProperty("结算金额")
	private BigDecimal settleprice;

	@ApiModelProperty("是否结算 0 预估未结算 1 结算预估 2 结算金额")
	private Integer issettle;

	@ApiModelProperty("创建时间")
	private Date createTime;
	
	@ApiModelProperty("结算时间")
	private Date settleTime;

	@ApiModelProperty("分类：1（0元购订单），2（非0元购订单）")
	@TableField(exist = false)
	private Integer type;

	@ApiModelProperty("0元购预估奖励")
	@TableField(exist = false)
	private  BigDecimal zeroPrice;
}

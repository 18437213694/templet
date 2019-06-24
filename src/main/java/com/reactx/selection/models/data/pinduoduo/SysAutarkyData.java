package com.reactx.selection.models.data.pinduoduo;

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

@Data
@ApiModel("自营商品")
@TableName("sys_autarky_data")
@EqualsAndHashCode(callSuper = true)
public class SysAutarkyData extends BaseModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@TableId(type= IdType.AUTO)
	private Long id;

	@ApiModelProperty("基础销量")
	@TableField("basic_sales")
	private Long basicSales;

	@ApiModelProperty("购买方式（1：微分销上购买，2：链接到外部购买）")
	@TableField("buy_method")
	private Integer buyMethod;

	@ApiModelProperty("创建时间")
	@TableField("createtime")
	private Long createtime;

	@ApiModelProperty("一级上级佣金")
	@TableField("directly_money")
	private BigDecimal directlyMoney;

	@ApiModelProperty("运费承担方式（1：卖家承担，包邮；2：统一运费；3：运费模板）")
	@TableField("freight_payer")
	private Integer freightPayer;

	@ApiModelProperty("页面是否显示商品库存（0：否，1：是）")
	@TableField("hide_stock")
	private Integer hideStock;

	@ApiModelProperty("轮播图")
	@TableField("small_images")
	private String smallImages;

	@ApiModelProperty("发票（0：无，1：有）")
	@TableField("invoice")
	private Integer invoice;

	@ApiModelProperty("商品id")
	@TableField("item_id")
	private String itemId;

	@ApiModelProperty("商品链接")
	@TableField("item_url")
	private String itemUrl;

	@ApiModelProperty("是否参与等级折扣（0：否，1：是）")
	@TableField("join_level_discount")
	private Integer joinLevelDiscount;

	@ApiModelProperty("商品数量")
	@TableField("num")
	private Long num;

	@ApiModelProperty("商品原价")
	@TableField("original_price")
	private BigDecimal originalPrice;

	@ApiModelProperty("运费")
	@TableField("post_fee")
	private BigDecimal postFee;

	@ApiModelProperty("现价")
	@TableField("price")
	private BigDecimal price;

	@ApiModelProperty("限购数量")
	@TableField("quota")
	private Long quota;

	@ApiModelProperty("销量")
	@TableField("sale_num")
	private Long saleNum;

	@ApiModelProperty("店铺id")
	@TableField("shop_id")
	private String shopId;

	@ApiModelProperty("淘宝类目id")
	@TableField("sid")
	private String sid;

	@ApiModelProperty("定时开售时间，为0表示立即开售")
	@TableField("sold_time")
	private String soldTime;

	@ApiModelProperty("状态（0：仓库中，1：出售中，2：已售罄，3：已删除）")
	@TableField("status")
	private Integer status;

	@ApiModelProperty("二级上级佣金")
	@TableField("superior_money")
	private BigDecimal superiorMoney;

	@ApiModelProperty("商品在淘宝的id")
	@TableField("taobao_id")
	private Long taobaoId;

	@ApiModelProperty("商品所属淘宝店铺id")
	@TableField("tb_shop_id")
	private Long tbShopId;

	@ApiModelProperty("三级上级佣金")
	@TableField("three_money")
	private BigDecimal threeMoney;

	@ApiModelProperty("标题")
	@TableField("title")
	private String title;

	@ApiModelProperty("保修（0：无，1：有）")
	@TableField("warranty")
	private Integer warranty;

}

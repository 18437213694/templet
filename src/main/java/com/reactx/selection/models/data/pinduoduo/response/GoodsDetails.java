package com.reactx.selection.models.data.pinduoduo.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@ApiModel("多多进宝商品对象")
public class GoodsDetails implements Serializable {
	/**
	* 
	*/
	private static final long serialVersionUID = 1L;

	@ApiModelProperty("参与多多进宝的商品ID")
	private Long goods_id;

	@ApiModelProperty("参与多多进宝的商品标题")
	private String goods_name;

	@ApiModelProperty("参与多多进宝的商品描述")
	private String goods_desc;

	@ApiModelProperty("多多进宝商品主图")
	private String goods_image_url;

	@ApiModelProperty("商品轮播图")
	private List<String> goods_gallery_urls;

	@ApiModelProperty("已售卖件数")
	private Long sold_quantity;

	@ApiModelProperty("最低价sku的拼团价，单位为分")
	private Long min_group_price;

	@ApiModelProperty("最低价sku的单买价，单位为分")
	private Long min_normal_price;

	@ApiModelProperty("店铺名称")
	private String mall_name;

	@ApiModelProperty("商品标签ID，使用pdd.goods.opt.get接口获取")
	private Long opt_id;

	@ApiModelProperty("商品标签名称")
	private String opt_name;

	@ApiModelProperty("商品标签ID")
	private List<Integer> opt_ids;

	@ApiModelProperty("商品一~四级类目ID列表")
	private List<Integer> cat_ids;

	@ApiModelProperty("优惠券门槛金额，单位为分")
	private Long coupon_min_order_amount;

	@ApiModelProperty("优惠券面额，单位为分")
	private Long coupon_discount;

	@ApiModelProperty("优惠券总数量")
	private Long coupon_total_quantity;

	@ApiModelProperty("优惠券剩余数量")
	private Long coupon_remain_quantity;

	@ApiModelProperty("优惠券生效时间，UNIX时间戳")
	private Long coupon_start_time;

	@ApiModelProperty("优惠券失效时间，UNIX时间戳")
	private Long coupon_end_time;

	@ApiModelProperty("佣金比例，千分比")
	private Long promotion_rate;

	@ApiModelProperty("商品评价分")
	private Double goods_eval_score;

	@ApiModelProperty("商品评价数")
	private Long goods_eval_count;

	@ApiModelProperty("商品类目ID，使用pdd.goods.cats.get接口获取")
	private Long cat_id;

	@ApiModelProperty("描述评分")
	private Long avg_desc;

	@ApiModelProperty("物流评分")
	private Long avg_lgst;

	@ApiModelProperty("服务评分")
	private Long avg_serv;

	@ApiModelProperty("描述评分击败同类店铺百分比")
	private Double desc_pct;

	@ApiModelProperty("物流评分击败同类店铺百分比")
	private Double lgst_pct;

	@ApiModelProperty("服务评分击败同类店铺百分比")
	private Double serv_pct;
}

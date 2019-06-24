package com.reactx.selection.models.data.pinduoduo.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@ApiModel("商品")
public class Goods implements Serializable {
	/**
	* 
	*/
	private static final long serialVersionUID = 1L;

	@ApiModelProperty("创建时间（unix时间戳）")
	private Long create_at;

	@ApiModelProperty("商品id")
	private Long goods_id;

	@ApiModelProperty("商品名称")
	private String goods_name;

	@ApiModelProperty("商品描述")
	private String goods_desc;

	@ApiModelProperty("商品缩略图")
	private String goods_thumbnail_url;

	@ApiModelProperty("商品主图")
	private String goods_image_url;

	@ApiModelProperty("商品轮播图")
	private List<String> goods_gallery_urls;

	@ApiModelProperty("已售卖件数")
	private Long sold_quantity;

	@ApiModelProperty("最小拼团价（单位为分）")
	private Long min_group_price;

	@ApiModelProperty("最小单买价格（单位为分）")
	private Long min_normal_price;

	@ApiModelProperty("店铺名字")
	private String mall_name;

	@ApiModelProperty("店铺类型，1-个人，2-企业，3-旗舰店，4-专卖店，5-专营店，6-普通店")
	private Integer merchant_type;

	@ApiModelProperty("商品类目ID，使用pdd.goods.cats.get接口获取")
	private Long category_id;

	@ApiModelProperty("商品类目名")
	private String category_name;

	@ApiModelProperty("商品标签ID，使用pdd.goods.opts.get接口获取")
	private Long opt_id;

	@ApiModelProperty("商品标签名")
	private String opt_name;

	@ApiModelProperty("商品标签id")
	private List<Long> opt_ids;

	@ApiModelProperty("商品类目id")
	private List<Long> cat_ids;

	@ApiModelProperty("该商品所在店铺是否参与全店推广，0：否，1：是")
	private Integer mall_cps;

	@ApiModelProperty("商品是否有优惠券 true-有，false-没有")
	private Boolean has_coupon;

	@ApiModelProperty("优惠券门槛价格，单位为分")
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

	@ApiModelProperty("商品评价数量")
	private Long goods_eval_count;

	@ApiModelProperty("描述评分")
	private Long avg_desc;

	@ApiModelProperty("物流评分")
	private Long avg_lgst;

	@ApiModelProperty("服务评分")
	private Long avg_serv;

	@ApiModelProperty("描述分击败同类店铺百分比")
	private Double desc_pct;

	@ApiModelProperty("物流分击败同类店铺百分比")
	private Double lgst_pct;

	@ApiModelProperty("服务分击败同类店铺百分比")
	private Double serv_pct;
}

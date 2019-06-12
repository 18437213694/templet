package com.reactx.selection.models.data.taobao.response;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel("淘宝客订单")
public class TbkOrder implements Serializable {/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long trade_parent_id;

	private String trade_id;

	private String num_iid;

	private String item_title;

	private Integer item_num;

	private String price;

	private String pay_price;

	private String seller_nick;

	private String seller_shop_title;

	private String commission;

	private String commission_rate;

	private String create_time;

	private String earning_time;

	private Integer tk_status;

	private String tk3rd_type;

	private Long tk3rd_pub_id;

	private String order_type;

	private String income_rate;

	private String pub_share_pre_fee;

	private String subsidy_rate;

	private String subsidy_type;

	private String terminal_type;

	private String auction_category;

	private String site_id;

	private String site_name;

	private String adzone_id;

	private String adzone_name;

	private String alipay_total_price;

	private String total_commission_rate;

	private String total_commission_fee;

	private String subsidy_fee;

	private Long relation_id;

	//private String relation_id;

	private Long special_id;

	private String click_time;


}

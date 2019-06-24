package com.reactx.selection.models.data.pinduoduo.response;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel("商品详情返回")
public class OrderDetailResponse implements Serializable {
	/**
	* 
	*/
	private static final long serialVersionUID = 1L;
	private String order_sn;
	private Long goods_id;
	private String goods_name;
	private String goods_thumbnail_url;
	private Integer goods_quantity;
	private Long goods_price;
	private Long order_amount;
	private Long promotion_rate;
	private Long promotion_amount;
	private String batch_no;
	private Integer order_status;
	private String order_status_desc;
	private Long order_create_time;
	private Long order_pay_time;
	private Long order_group_success_time;
	private Long order_receive_time;
	private Long order_verify_time;
	private Long order_settle_time;
	private Long order_modify_at;
	private Integer match_channel;
	private Integer type;
	private Long group_id;
	private Long auth_duo_id;
	private Long zs_duo_id;
	private String custom_parameters;
	private String cps_sign;
	private Long url_last_generate_time;
	private Long point_time;
	private Integer return_status;
	private String pid;

}

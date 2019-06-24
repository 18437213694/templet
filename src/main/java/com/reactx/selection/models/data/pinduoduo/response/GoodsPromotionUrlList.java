package com.reactx.selection.models.data.pinduoduo.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel("多多进宝推广链接对象")
public class GoodsPromotionUrlList implements Serializable{/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@ApiModelProperty("唤起微信app推广短链接")
	private String we_app_web_view_short_url;
	
	@ApiModelProperty("唤起微信app推广链接")
	private String we_app_web_view_url;
	
	@ApiModelProperty("唤醒拼多多app的推广短链接")
	private String mobile_short_url;
	
	@ApiModelProperty("唤醒拼多多app的推广长链接")
	private String mobile_url;
	
	@ApiModelProperty("推广短链接")
	private String short_url;
	
	@ApiModelProperty("推广长链接")
	private String url;
	
	@ApiModelProperty("小程序信息")
	private weAppInfo we_app_info;

}

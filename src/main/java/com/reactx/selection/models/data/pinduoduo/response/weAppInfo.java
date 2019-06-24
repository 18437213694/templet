package com.reactx.selection.models.data.pinduoduo.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel("小程序信息")
public class weAppInfo implements Serializable {
	/**
	* 
	*/
	private static final long serialVersionUID = 1L;

	@ApiModelProperty("小程序图片")
	private String we_app_icon_url;

	@ApiModelProperty("Banner图")
	private String banner_url;

	@ApiModelProperty("描述")
	private String desc;

	@ApiModelProperty("来源名")
	private String source_display_name;

	@ApiModelProperty("小程序path值")
	private String page_path;

	@ApiModelProperty("用户名")
	private String user_name;

	@ApiModelProperty("小程序标题")
	private String title;

	@ApiModelProperty("拼多多小程序id")
	private String app_id;

}

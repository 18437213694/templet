package com.reactx.selection.models.data.taobao.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel("创建淘口令")
public class CreateTbkTpwdRequest implements Serializable {/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@ApiModelProperty("口令弹框内容")
	private String text;
	
	@ApiModelProperty("口令跳转目标页")
	private String url;
	
	@ApiModelProperty("口令弹框logoURL")
	private String logo;

	@ApiModelProperty("用户ID")
	private String userId;

	@ApiModelProperty("unionid")
	private String unionid;

	@ApiModelProperty("渠道ID")
	private String relationId;

}

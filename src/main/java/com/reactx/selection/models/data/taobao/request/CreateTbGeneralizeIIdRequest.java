package com.reactx.selection.models.data.taobao.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("创建推广位id请求")
public class CreateTbGeneralizeIIdRequest {

	@ApiModelProperty("siteid")
	private String siteid;

	@ApiModelProperty("cookies")
	private String cookies;

	@ApiModelProperty("token")
	private String token;

	@ApiModelProperty("pvid")
	private String pvid;

	@ApiModelProperty("数量")
	private Integer num;

	@ApiModelProperty("上一个adzoneId")
	private String lastAdzoneId;
}

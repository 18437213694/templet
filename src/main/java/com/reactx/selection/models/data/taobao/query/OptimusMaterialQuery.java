package com.reactx.selection.models.data.taobao.query;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class OptimusMaterialQuery {

	@ApiModelProperty("当前页")
	private Long pageNo = 1L;

	@ApiModelProperty("分页大小")
	private Long pageSize = 20L;

	@ApiModelProperty("用户id")
	private Long userId;
	
	@ApiModelProperty("推广位id")
	private Long adzoneId;

	@ApiModelProperty("设备号MD5后的值")
	private String deviceValue;

	@ApiModelProperty("设备号类型")
	private String deviceType;
}

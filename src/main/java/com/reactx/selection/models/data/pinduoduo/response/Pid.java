package com.reactx.selection.models.data.pinduoduo.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class Pid implements Serializable {
	/**
	* 
	*/
	private static final long serialVersionUID = 1L;

	@ApiModelProperty("推广位名称")
	private String p_id_name;

	@ApiModelProperty("调用方推广位ID")
	private String p_id;

	@ApiModelProperty("推广位生成时间")
	private Long create_time;

}

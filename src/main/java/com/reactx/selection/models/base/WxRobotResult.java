package com.reactx.selection.models.base;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "WxRobotResult", description = "")
@JsonIgnoreProperties
public class WxRobotResult<T> {

	public WxRobotResult() {
	}

	public WxRobotResult(String errno, String errmsg) {
		this.errno = errno;
		this.errmsg = errmsg;
	}

	public WxRobotResult(String errno, String errmsg, T data) {
		this.errno = errno;
		this.errmsg = errmsg;
		this.data = data;
	}
	

	@ApiModelProperty(value = "状态码.200(OK)")
	private String errno;

	@ApiModelProperty(value = "返回的消息")
	private String errmsg;

	@ApiModelProperty(value = "返回的数据")
	private T data;

	public String getErrno() {
		return errno;
	}

	public void setErrno(String errno) {
		this.errno = errno;
	}

	public String getErrmsg() {
		return errmsg;
	}

	public void setErrmsg(String errmsg) {
		this.errmsg = errmsg;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
}

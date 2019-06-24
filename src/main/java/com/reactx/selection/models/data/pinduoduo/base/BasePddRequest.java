package com.reactx.selection.models.data.pinduoduo.base;

import lombok.Data;

import java.io.Serializable;

@Data
public class BasePddRequest implements Serializable {
	/**
	* 
	*/
	private static final long serialVersionUID = 1L;

	private String type;
	private String client_id;
	private String access_token;
	private String timestamp;
	private String data_type = "JSON";
	private String version;
	private String sign;
}

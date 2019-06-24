package com.reactx.selection.models.data.pinduoduo.response;

import lombok.Data;

import java.io.Serializable;

@Data
public class ErrorResponse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String error_msg;
	private String sub_msg;
	private String sub_code;
	private String error_code;
	private String request_id;

}

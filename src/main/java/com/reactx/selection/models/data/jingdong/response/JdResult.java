package com.reactx.selection.models.data.jingdong.response;

import lombok.Data;

import java.io.Serializable;

@Data
public class JdResult<T> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer error;

	private String msg;
	
	private Integer total;

	private T data;

}

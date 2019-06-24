package com.reactx.selection.models.data.jingdong.response;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class JdOrderResponse implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer error;
	private String msg;
	private Integer hasmore;
	private List<JdOrder> data;
}

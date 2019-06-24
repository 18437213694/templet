package com.reactx.selection.models.data.jingdong.response;

import lombok.Data;

import java.io.Serializable;

@Data
public class Coupon implements Serializable {
	/**
	* 
	*/
	private static final long serialVersionUID = 1L;

	private String beginTime;
	private String bindType;
	private String discount;
	private String endTime;
	private String link;
	private String platformType;
	private String quota;
}

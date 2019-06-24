package com.reactx.selection.models.data.jingdong.request;

import lombok.Data;

import java.io.Serializable;

@Data
public class LinkRequest implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String couponurl;
	private String materialids;
	private Long userId;
	private Integer positionid;

}

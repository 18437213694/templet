package com.reactx.selection.models.data.taobao.response;

import lombok.Data;

import java.io.Serializable;

/**
 * 
 * @author 虚无缥缈
 *
 */
@Data
public class TaobaoCodeDecodeResponse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String title;
	private String pictUrl;
	private Long numIid;
	private Integer userType;
	private String itemUrl;
	private Integer error;
	private String msg;

}

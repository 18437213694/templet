package com.reactx.selection.models.data.request;

import lombok.Data;

import java.io.Serializable;

@Data
public class CreateClickUrlRequest implements Serializable {
	/**
	* 
	*/
	private static final long serialVersionUID = 1L;

	private Long userId;

	private String url;

}

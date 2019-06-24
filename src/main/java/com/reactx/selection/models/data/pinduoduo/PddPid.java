package com.reactx.selection.models.data.pinduoduo;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel("拼多多pid")
public class PddPid implements Serializable {
	/**
	* 
	*/
	private static final long serialVersionUID = 1L;

	private Long userId;

	private String pid;

	public PddPid(Long userId, String pid) {
		super();
		this.userId = userId;
		this.pid = pid;
	}

	public PddPid() {
		super();
	}
}

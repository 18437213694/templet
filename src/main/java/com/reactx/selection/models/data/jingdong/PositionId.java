package com.reactx.selection.models.data.jingdong;

import lombok.Data;

import java.io.Serializable;

@Data
public class PositionId implements Serializable {
	/**
	* 
	*/
	private static final long serialVersionUID = 1L;
	private Long userId;
	private Integer pid;
	private Integer name;

	public PositionId(Integer pid, Integer name) {
		super();
		this.userId = 0L;
		this.pid = pid;
		this.name = name;
	}

	public PositionId() {
		super();
	}

}

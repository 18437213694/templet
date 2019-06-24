package com.reactx.selection.models.data.pinduoduo.base;

import lombok.Data;

import java.io.Serializable;

@Data
public class Param implements Comparable<Param>,Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String key;

	private String value;

	@Override
	public int compareTo(Param o) {
		return this.key.compareTo(o.getKey());
	}

	public Param(String key, String value) {
		super();
		this.key = key;
		this.value = value;
	}

	public Param() {
		super();
	}

}

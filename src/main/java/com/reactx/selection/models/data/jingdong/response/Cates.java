package com.reactx.selection.models.data.jingdong.response;

import lombok.Data;

import java.io.Serializable;

@Data
public class Cates implements Serializable {
	/**
	* 
	*/
	private static final long serialVersionUID = 1L;

	private Integer grade;
	private Integer id;
	private String name;
	private Integer parentId;

}

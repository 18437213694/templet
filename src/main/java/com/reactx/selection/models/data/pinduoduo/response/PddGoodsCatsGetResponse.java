package com.reactx.selection.models.data.pinduoduo.response;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class PddGoodsCatsGetResponse implements Serializable {/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private List<GoodsCatsList> goods_cats_list;

}

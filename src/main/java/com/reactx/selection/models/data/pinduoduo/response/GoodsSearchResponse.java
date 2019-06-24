package com.reactx.selection.models.data.pinduoduo.response;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class GoodsSearchResponse implements Serializable {/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private List<Goods> goods_list;
	private Integer total_count;
}

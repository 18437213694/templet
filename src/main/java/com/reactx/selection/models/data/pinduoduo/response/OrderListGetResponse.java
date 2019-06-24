package com.reactx.selection.models.data.pinduoduo.response;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class OrderListGetResponse implements Serializable {
	/**
	* 
	*/
	private static final long serialVersionUID = 1L;

	private List<Order> order_list;
	private Long total_count;
}

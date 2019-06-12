package com.reactx.selection.models.data.taobao.response;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@ApiModel("淘宝客订单返回")
public class TbkScOrderResponse implements Serializable {
	/**
	* 
	*/
	private static final long serialVersionUID = 1L;

	private String error;

	private String msg;

	private List<TbkOrder> data;
}

package com.reactx.selection.models.data.taobao.query;

import com.reactx.selection.models.base.page.PageHelp;
import com.reactx.selection.models.data.taobao.response.TbkOrder;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


@Data
@ApiModel("订单分页请求")
public class TbkOrderQuery extends PageHelp<TbkOrder> {
	/**
	* 
	*/
	private static final long serialVersionUID = 1L;

	@ApiModelProperty("开始时间")
	private String startTime;

	public TbkOrderQuery(String startTime) {
		super();
		this.startTime = startTime;
	}

	public TbkOrderQuery() {
		super();
	}
	
}

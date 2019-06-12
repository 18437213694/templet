package com.reactx.selection.models.data.taobao.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel("淘宝客订单请求")
public class TbkScOrderRequest implements Serializable {
	/**
	* 
	*/
	private static final long serialVersionUID = 1L;

	@ApiModelProperty("订单查询开始时间")
	private String startTime;

	@ApiModelProperty("订单查询时间范围，单位：秒，最小60，最大1200，默认60")
	private Integer span = 120;

	@ApiModelProperty("第几页，默认1，1~100")
	private Integer pageNo = 1;

	@ApiModelProperty("页大小，默认20，1~100")
	private Integer pageSize = 20;

	@ApiModelProperty("订单状态，1: 全部订单，3：订单结算，12：订单付款， 13：订单失效，14：订单成功； 订单查询类型为‘结算时间’时，只能查订单结算状态")
	private Integer tkStatus = 1;

	@ApiModelProperty("订单查询类型，创建时间“create_time”，或结算时间“settle_time”")
	private String orderQueryType = "create_time";

	@ApiModelProperty("订单场景类型，1:常规订单，2:渠道订单，3:会员运营订单，默认为1，通过设置订单场景类型，媒体可以查询指定场景下的订单信息，例如不设置，或者设置为1，表示查询常规订单，常规订单包含淘宝客所有的订单数据，含渠道，及会员运营订单，但不包含3方分成，及维权订单")
	private Integer orderScene = 1;

	@ApiModelProperty("订单数据统计类型，1: 2方订单，2: 3方订单，如果不设置，或者设置为1，表示2方订单")
	private Integer orderCountType = 1;

}

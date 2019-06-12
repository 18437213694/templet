package com.reactx.selection.models.data.taobao.query;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel("新首页分页请求类")
public class PageNewQuery implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@ApiModelProperty("当前页")
	private Long pageNo = 1L;

	@ApiModelProperty("分页大小")
	private Long pageSize = 20L;

	@ApiModelProperty(value = "排序列(不需要则为null)", allowableValues = "销量（total_sales），淘客佣金比率（tk_rate）， 累计推广量（tk_total_sales），总支出佣金（tk_total_commi），价格（price）")
	private String orderByField;

	@ApiModelProperty(value = "排序方式(排序列存在则排序方式必须存在)", allowableValues = "true,false")
	private Boolean isAsc;

	@ApiModelProperty("关键字")
	private String keyword;

//	@ApiModelProperty("用户id")
//	private Long userId;
//
//	@ApiModelProperty("微信id")
//	private String wechatid;

	@ApiModelProperty("折扣价范围上限，单位：元")
	private Long endPrice;

	@ApiModelProperty("折扣价范围下限，单位：元")
	private Long startPrice;

	@ApiModelProperty("是否包邮")
	private Boolean needFreeShipment;

	@ApiModelProperty("推广位id")
	private Long adzoneId;

	@ApiModelProperty("ip")
	private String ip;

	@ApiModelProperty("商品筛选-后台类目ID")
	private String cat;

}

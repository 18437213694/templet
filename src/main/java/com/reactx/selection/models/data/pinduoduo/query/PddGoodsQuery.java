package com.reactx.selection.models.data.pinduoduo.query;

import com.reactx.selection.models.base.page.PageHelp;
import com.reactx.selection.models.data.pinduoduo.response.Goods;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@ApiModel("商品查询")
@EqualsAndHashCode(callSuper = true)
public class PddGoodsQuery extends PageHelp<Goods> {
	/**
	* 
	*/
	private static final long serialVersionUID = 1L;

	@ApiModelProperty("关键字")
	private String keyword;

	@ApiModelProperty("排序方式")
	private Integer sortType;

	@ApiModelProperty("类目id")
	private Long catId;
	
	@ApiModelProperty("商品id")
	private String goodsId;

	@ApiModelProperty("店铺类型")
	private Integer merchantType;

}

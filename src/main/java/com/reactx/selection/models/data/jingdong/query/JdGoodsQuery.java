package com.reactx.selection.models.data.jingdong.query;

import com.reactx.selection.models.base.page.PageHelp;
import com.reactx.selection.models.data.jingdong.response.JdGoods;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@ApiModel("商品分页请求")
@EqualsAndHashCode(callSuper = true)
public class JdGoodsQuery extends PageHelp<JdGoods> {
	/**
	* 
	*/
	private static final long serialVersionUID = 1L;

	@ApiModelProperty("商品关键词")
	private String keyword;

	@ApiModelProperty("商品价格下限")
	private String pricefrom;

	@ApiModelProperty("商品价格上限")
	private String priceto;

	@ApiModelProperty("三级类目")
	private String cid3;

}

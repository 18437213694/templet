package com.reactx.selection.models.data.pinduoduo.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel("")
public class GoodsCatsList implements Serializable {
	/**
	* 
	*/
	private static final long serialVersionUID = 1L;

	@ApiModelProperty("类目层级，1-一级类目，2-二级类目，3-三级类目，4-四级类目")
	private Integer level;
	
	@ApiModelProperty("商品类目名称")
	private String catName;
	
	@ApiModelProperty("id所属父类目ID，其中，parent_id=0时为顶级节点")
	private Long parentCatId;
	
	@ApiModelProperty("商品类目ID")
	private Long catId;
}

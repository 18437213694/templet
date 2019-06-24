package com.reactx.selection.models.data.pinduoduo.response;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@ApiModel("商品详情返回")
public class GoodsDetailResponse implements Serializable {/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private List<GoodsDetails> goods_details;

}

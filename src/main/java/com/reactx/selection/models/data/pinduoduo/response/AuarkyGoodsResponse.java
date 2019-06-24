package com.reactx.selection.models.data.pinduoduo.response;

import com.baomidou.mybatisplus.annotations.TableField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Data
@ApiModel("多多进宝商品对象")
public class AuarkyGoodsResponse implements Serializable {
	/**
	* 
	*/
	private static final long serialVersionUID = 1L;


	@ApiModelProperty("轮播图")
	private String smallImages;

	@ApiModelProperty("商品id")
	private String itemId;

	@ApiModelProperty("商品链接")
	private String itemUrl;

	@ApiModelProperty("商品数量")
	private Long num;

	@ApiModelProperty("商品原价")
	private BigDecimal originalPrice;

	@ApiModelProperty("现价")
	private BigDecimal price;

	@ApiModelProperty("销量")
	private Long saleNum;

	@ApiModelProperty("状态（0：仓库中，1：出售中，2：已售罄，3：已删除）")
	private Integer status;

	@ApiModelProperty("标题")
	private String title;

}

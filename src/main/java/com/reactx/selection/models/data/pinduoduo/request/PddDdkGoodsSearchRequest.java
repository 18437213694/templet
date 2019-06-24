package com.reactx.selection.models.data.pinduoduo.request;

import com.reactx.selection.models.data.pinduoduo.base.BasePddRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class PddDdkGoodsSearchRequest extends BasePddRequest {
	/**
	* 
	*/
	private static final long serialVersionUID = 1L;

	private String keyword;
	private Long opt_id;
	private Integer page;
	private Integer page_size;
	private Integer sort_type;
	private Boolean with_coupon;
	private String range_list;
	private Long cat_id;
	private String goods_id_list;
	private Long zs_duo_id;
	private Integer merchant_type;
	private String pid;
	private String custom_parameters;

}

package com.reactx.selection.models.data.pinduoduo.response;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class PddDdkGoodsPromotionUrlGenerateResponse implements Serializable{/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private List<GoodsPromotionUrlList> goods_promotion_url_list;

}

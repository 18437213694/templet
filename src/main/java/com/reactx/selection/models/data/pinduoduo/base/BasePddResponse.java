package com.reactx.selection.models.data.pinduoduo.base;

import com.reactx.selection.models.data.pinduoduo.response.*;
import lombok.Data;

import java.io.Serializable;

@Data
public class BasePddResponse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private ErrorResponse error_response;
	private PddGoodsCatsGetResponse goods_cats_get_response;
	private GoodsSearchResponse goods_search_response;
	private GoodsDetailResponse goods_detail_response;
	private PidGenerateResponse p_id_generate_response;
	private PidQueryResponse p_id_query_response;
	private PddDdkGoodsPromotionUrlGenerateResponse goods_promotion_url_generate_response;
	private OrderListGetResponse order_list_get_response;
	private OrderDetailResponse order_detail_response;

}

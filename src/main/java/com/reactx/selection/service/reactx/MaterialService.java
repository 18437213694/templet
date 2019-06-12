package com.reactx.selection.service.reactx;


import com.reactx.selection.models.base.Result;
import com.reactx.selection.models.base.page.Page;
import com.reactx.selection.models.data.taobao.query.OptimusMaterialQuery;
import com.reactx.selection.models.data.taobao.query.PageQuery;
import com.reactx.selection.models.data.taobao.request.CreateTbkTpwdRequest;
import com.taobao.api.ApiException;
import com.taobao.api.response.TbkDgMaterialOptionalResponse.MapData;
import com.taobao.api.response.TbkItemInfoGetResponse.NTbkItem;

import java.util.List;

/**
 * 物料
 *
 */
public interface MaterialService {

	/**
	 * 获取分页
	 * 
	 * @param query
	 * @return
	 */
	Page<MapData> getPage(PageQuery query) throws ApiException;

	/**
	 * 获取商品详情
	 * 
	 * @param itemId
	 * @param ip
	 * @return
	 */
	List<NTbkItem> getItemInfo(String itemId, String ip) throws ApiException;

	/**
	 * 创建淘口令
	 * 
	 * @param request
	 * @return
	 * @throws ApiException
	 */
	Result<Object> createTbkTpwd(CreateTbkTpwdRequest request) throws ApiException;

	/**
	 * 淘宝客物料下行
	 * 
	 * @param query
	 * @return
	 */
	Page<com.taobao.api.response.TbkDgOptimusMaterialResponse.MapData> optimusMaterialPage(OptimusMaterialQuery query)
			throws ApiException;

}

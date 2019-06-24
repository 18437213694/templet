package com.reactx.selection.service.reactx.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.reactx.selection.models.base.BaseService;
import com.reactx.selection.models.data.local.KeguanShop;

import java.util.List;
import java.util.Set;

public interface KeguanShopService extends BaseService<KeguanShop> {

	/**
	 * 获取所有的市
	 * @return
	 */
	Set<String> getAllCity();

	/**
	 * 分页查询
	 * 
	 * @param
	 * @return
	 */
	List<KeguanShop> findPage(String cityName,String shopName,Integer pageSize,Integer pageNo,String wechatid);

	/**
	 * 根据id查询
	 * 
	 * @param shopId
	 * @return
	 */
	KeguanShop findById(Long shopId);

	List<KeguanShop> getHotClassList(Integer status);
}

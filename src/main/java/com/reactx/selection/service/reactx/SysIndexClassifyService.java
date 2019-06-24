package com.reactx.selection.service.reactx;

import com.reactx.selection.models.base.BaseService;
import com.reactx.selection.models.data.jingdong.SysIndexClassify;

import java.util.List;

public interface SysIndexClassifyService extends BaseService<SysIndexClassify> {

	/**
	 * 获取全部
	 * @param type 
	 * @return
	 */
	List<SysIndexClassify> findAll(String type);

}

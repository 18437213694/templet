package com.reactx.selection.service.reactx;

import com.reactx.selection.models.base.BaseService;
import com.reactx.selection.models.data.pinduoduo.SysAutarkyData;

import java.util.List;

public interface SysAuarkyDataService extends BaseService<SysAutarkyData> {

	List<SysAutarkyData> findPage(Integer pageNo, Integer pageSize, String keyword, String sortType);

	Long getCount(Integer pageNo, Integer pageSize, String keyword);
}

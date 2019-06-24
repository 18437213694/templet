package com.reactx.selection.service.reactx.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.reactx.selection.mappers.SysIndexClassifyMapper;
import com.reactx.selection.models.base.BaseServiceImpl;
import com.reactx.selection.models.data.jingdong.SysIndexClassify;
import com.reactx.selection.service.reactx.SysIndexClassifyService;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysIndexClassifyServiceImpl extends BaseServiceImpl<SysIndexClassifyMapper, SysIndexClassify>
		implements SysIndexClassifyService {

	@Override
//	@Cacheable(value = "class", key = "'index_class_type_' + #type", unless = "#result.size() == 0")
	public List<SysIndexClassify> findAll(String type) {
		return baseMapper.querySysIndex(type);
	}

}

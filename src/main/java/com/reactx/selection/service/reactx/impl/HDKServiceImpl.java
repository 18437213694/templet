package com.reactx.selection.service.reactx.impl;

import com.reactx.selection.service.reactx.HDKService;
import com.reactx.selection.mappers.HDKMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class HDKServiceImpl implements HDKService {

	@Autowired
	HDKMapper hdkMapper;

	@Override
	public String getBrandClassfy(String name) {
		return hdkMapper.getClassfy(name);
	}
}

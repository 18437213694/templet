package com.reactx.selection.service.reactx.impl;

import com.reactx.selection.configs.TaobaoConfig;
import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class BaseTaobaoServiceImpl {

	private static String url = "http://gw.api.taobao.com/router/rest";
	@Autowired
	private TaobaoConfig config;

	/**
	 * 获取客户端
	 * 
	 * @return
	 */
	public TaobaoClient getClient() {
		return new DefaultTaobaoClient(url, config.getAppKey(), config.getAppSecret());
	}

}

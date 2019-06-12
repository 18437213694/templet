package com.reactx.selection.configs;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Data
@Component
public class TaobaoConfig {

	@Value("${taobao.appKey}")
	private String appKey;

	@Value("${taobao.appSecret}")
	private String appSecret;
	
	@Value("${taobao.veKey}")
	private String veKey;

}

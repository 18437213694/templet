package com.reactx.selection.configs;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Data
@Component
public class PddConfig {

	@Value("${pdd.clientId}")
	private String clientId;

	@Value("${pdd.clientSecret}")
	private String clientSecret;
	
	@Value("${pdd.url}")
	private String url;
	
}

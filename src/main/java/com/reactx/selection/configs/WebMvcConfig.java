package com.reactx.selection.configs;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {

	/**
	 * 文件磁盘地址
	 */
	@Value("${image.baseDir}")
	private String baseDir;

	/**
	 * 文件相对地址
	 */
	@Value("${image.baseURL}")
	private String baseURL;

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {

		// 文件磁盘图片url 映射
		registry.addResourceHandler("/img/**").addResourceLocations("file:" + this.baseDir);
		super.addResourceHandlers(registry);
	}

	public String getBaseDir() {
		return baseDir;
	}

	public String getBaseURL() {
		return baseURL;
	}
	
}

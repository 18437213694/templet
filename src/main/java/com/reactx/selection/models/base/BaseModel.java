package com.reactx.selection.models.base;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;

import java.io.Serializable;

@ApiModel
@JsonIgnoreProperties(ignoreUnknown = true)
public class BaseModel implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * jackson 基础数据过滤,只过滤BaseModel类中的字段
	 * 
	 * @author eleven.
	 */
	public interface BaseView {
	};


}

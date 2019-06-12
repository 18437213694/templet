package com.reactx.selection.models.data.taobao;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel("推广位id")
public class GeneralizeId implements Serializable {
	/**
	* 
	*/
	private static final long serialVersionUID = 1L;

	@ApiModelProperty("名称")
	private Integer name;

	@ApiModelProperty("site_id")
	private String siteId;

	@ApiModelProperty("adzone_id")
	private String adzoneId;

	@ApiModelProperty("是否使用")
	private Boolean isUse;

	public GeneralizeId(Integer name, String siteId, String adzoneId, Boolean isUse) {
		super();
		this.name = name;
		this.siteId = siteId;
		this.adzoneId = adzoneId;
		this.isUse = isUse;
	}

	public GeneralizeId() {
		super();
	}
}

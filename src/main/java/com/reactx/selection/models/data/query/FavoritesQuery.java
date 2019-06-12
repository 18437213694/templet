package com.reactx.selection.models.data.query;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel("选品库分页请求")
public class FavoritesQuery implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@ApiModelProperty("当前页")
	private long pageNo = 1L;

	@ApiModelProperty("分页大小")
	private long pageSize = 20L;

	@ApiModelProperty("用户id")
	private long userId;
	
	@ApiModelProperty("推广位id")
	private Long adzoneId;
	
	@ApiModelProperty("选品库id")
	private Long favoritesId;
	
	public FavoritesQuery(long pageNo, long pageSize) {
		super();
		this.pageNo = pageNo;
		this.pageSize = pageSize;
	}

	
	
	public FavoritesQuery() {
		super();
	}



	public FavoritesQuery(long pageNo, long pageSize, Long adzoneId, Long favoritesId) {
		super();
		this.pageNo = pageNo;
		this.pageSize = pageSize;
		this.adzoneId = adzoneId;
		this.favoritesId = favoritesId;
	}
	
	
}

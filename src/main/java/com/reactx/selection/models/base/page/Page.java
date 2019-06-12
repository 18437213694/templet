package com.reactx.selection.models.base.page;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@ApiModel("分页")
@JsonIgnoreProperties
public class Page<T> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@ApiModelProperty("查询数据列表")
	private List<T> records;

	@ApiModelProperty("总数")
	private Long total;

	@ApiModelProperty("每页显示条数，默认 20")
	private Long size = 20L;

	@ApiModelProperty("当前页")
	private Long current = 1L;

	@ApiModelProperty("总页数")
	private Long pages;

	public Page(List<T> records, Long total, Long size, Long current) {
		super();
		this.records = records;
		this.total = total;
		this.size = size;
		this.current = current;
	}

	public boolean hasNext() {
		return this.current < getPages();
	}

	public Long getPages() {
		if (this.size == 0) {
			return 0L;
		}
		this.pages = this.total / this.size;
		if (this.total % this.size != 0) {
			this.pages++;
		}
		return this.pages;
	}
}

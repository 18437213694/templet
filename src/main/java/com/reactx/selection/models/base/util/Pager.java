package com.reactx.selection.models.base.util;

import com.baomidou.mybatisplus.plugins.Page;

public class Pager<T> extends Page<T> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int pages;

	public int getPages() {
		return this.pages;
	}

	public void setPages(int pages) {
		this.pages = pages;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}

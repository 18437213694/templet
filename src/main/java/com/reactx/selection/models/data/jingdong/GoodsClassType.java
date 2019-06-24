package com.reactx.selection.models.data.jingdong;

public enum GoodsClassType {

	TAO_BAO("淘宝"), JING_DONG("京东"),PIN_DUO_DUO("拼多多");

	private String title;

	private GoodsClassType(String title) {
		this.title = title;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}

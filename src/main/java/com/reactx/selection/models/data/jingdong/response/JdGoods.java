package com.reactx.selection.models.data.jingdong.response;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class JdGoods implements Serializable {
	/**
	* 
	*/
	private static final long serialVersionUID = 1L;
	
	private String cid;
	private String cid2;
	private String cid2Name;
	private String cid3;
	private String cid3Name;
	private String cidName;
	private String commissionShare;
	private List<Coupon> couponList;
	private String imageurl;
	private String imgUrl;
	private String inOrderCount;
	private String isJdSale;
	private String isSeckill;
	private String materiaUrl;
	private String pcPrice;
	private String skuId;
	private String skuName;
	private String vid;
	private String wlCommissionShare;
	private String wlPrice;

}

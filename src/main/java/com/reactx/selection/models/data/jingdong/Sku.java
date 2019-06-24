package com.reactx.selection.models.data.jingdong;

import lombok.Data;

import java.io.Serializable;

@Data
public class Sku implements Serializable {
	/**
	* 
	*/
	private static final long serialVersionUID = 1L;
	
	private String actualCommission;
	private String actualCosPrice;
	private String actualFee;
	private String commissionRate;
	private String estimateCommission;
	private String estimateCosPrice;
	private String estimateFee;
	private String finalRate;
	private String firstLevel;
	private String frozenSkuNum;
	private String payMonth;
	private String payPrice;
	private String pid;
	private String popId;
	private String price;
	private String secondLevel;
	private String siteId;
	private String skuId;
	private String skuName;
	private Integer skuNum;
	private String skuReturnNum;
	private String spId;
	private String subSideRate;
	private String subUnionId;
	private String subsidyRate;
	private String thirdLevel;
	private String traceType;
	private String unionAlias;
	private String unionTag;
	private String unionTrafficGroup;
	private String validCode;

}


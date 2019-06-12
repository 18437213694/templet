package com.reactx.selection.models.data.taobao.response;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class MapData implements Serializable {

	private static final long serialVersionUID = 6541293552774358568L;

	private Long categoryId;
	private String categoryName;
	private String commissionRate;
	private String commissionType;
	private String couponEndTime;
	private String couponId;
	private String couponInfo;
	private Long couponRemainCount;
	private String couponShareUrl;
	private String couponStartTime;
	private Long couponTotalCount;
	private String includeDxjh;
	private String includeMkt;
	private String infoDxjh;
	private String itemUrl;
	private Long jddNum;
	private String jddPrice;
	private Long levelOneCategoryId;
	private String levelOneCategoryName;
	private Long numIid;
	private String oetime;
	private String ostime;
	private String pictUrl;
	private String provcity;
	private String reservePrice;
	private Long sellerId;
	private Long shopDsr;
	private String shopTitle;
	private String shortTitle;
	private List<String> smallImages;
	private String title;
	private String tkTotalCommi;
	private String tkTotalSales;
	private String url;
	private Long userType;
	private Long uvSumPreSale;
	private Long volume;
	private String whiteImage;
	private String zkFinalPrice;
	private String aboutReturn;

}

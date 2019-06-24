package com.reactx.selection.models.data.local;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.reactx.selection.models.base.BaseModel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;
import java.util.List;

@Data
@ApiModel("门店")
@TableName("keguan_shop")
@EqualsAndHashCode(callSuper = true)
public class KeguanShop extends BaseModel {
	/**
	* 
	*/
	private static final long serialVersionUID = 1L;

	@TableId(value = "ID", type = IdType.AUTO)
	private Long id;

	@TableField("merchantid")
	@ApiModelProperty("所属商户id")
	private Long merchantId;

	@TableField("shopname")
	@ApiModelProperty("门店名称")
	private String shopName;

	@TableField("shopsubname")
	@ApiModelProperty("门店子名称")
	private String shopSubName;

	@TableField("provinceid")
	@ApiModelProperty("所在省份")
	private Long provinceId;

	@TableField("cityid")
	@ApiModelProperty("所在城市")
	private Long cityId;

	@TableField("countyid")
	@ApiModelProperty("所在县区")
	private Long countyId;

	@TableField("creator")
	@ApiModelProperty("创建人")
	private Long creator;

	@TableField("createtime")
	@ApiModelProperty("创建时间")
	private Date createTime;

	@TableField("status")
	@ApiModelProperty("状态,1：营业中，0：已停业，2：新店特惠分类，4：热门好店分类")
	private Integer status;

	@TableField("contact")
	@ApiModelProperty("联系人")
	private String contact;

	@TableField("phone")
	@ApiModelProperty("联系人手机")
	private String phone;

	@TableField("telephone")
	@ApiModelProperty("门店电话")
	private String telephone;

	@TableField("address")
	@ApiModelProperty("详细地址")
	private String address;

	@TableField("openingtime")
	@ApiModelProperty("营业时间")
	private Date openingTime;

	@TableField("closingtime")
	@ApiModelProperty("打烊时间")
	private Date closingTime;

	@TableField("remark")
	@ApiModelProperty("备注")
	private String remark;

	@TableField("csmshopid")
	@ApiModelProperty("csm门店id")
	private Long csmShopId;

	@TableField("wxid")
	@ApiModelProperty("wxid")
	private Long wxID;

	@TableField("categories")
	@ApiModelProperty("行业")
	private String categories;

	@TableField("longitude")
	@ApiModelProperty("门店所在地理位置的经度 坐标拾取器http://lbs.qq.com/tool/getpoint/index.html")
	private String longitude;

	@TableField("latitude")
	@ApiModelProperty("纬度")
	private String latitude;

	@TableField("images")
	@ApiModelProperty("多图，用,分隔")
	private String images;

	@TableField("local_image")
	@ApiModelProperty("封面大图")
	private String localImage;
	
	@ApiModelProperty("分类id")
	private String classId;

	@ApiModelProperty("商圈分类id")
	private Long tradingAreaId;

	@ApiModelProperty("门店简介")
	private String label;

	@ApiModelProperty("卡券集合")
	@TableField(exist=false)
	private List<KeguanWxcardinfo> cards;
	
	@ApiModelProperty("卡券数量")
	@TableField(exist=false)
	private Integer cardNum;
	
	@ApiModelProperty("领卡人数")
	@TableField(exist=false)
	private Integer number;
	
	@ApiModelProperty("分类名称")
	@TableField(exist=false)
	private String className;

	@TableField(exist = false)
	@ApiModelProperty("最小折扣")
	private Double minDiscount;

	@TableField(exist = false)
	@ApiModelProperty("最大折扣现金")
	private Double maxReduceMoney;

	@TableField(exist = false)
	@ApiModelProperty("礼品数量")
	private Integer giftNum;

	@TableField(exist = false)
	@ApiModelProperty("活动")
	private KeguanActivity activity;

	@ApiModelProperty("是否推荐")
	private Boolean isRecommend;

	@TableField("logo")
	@ApiModelProperty("头像")
	private String logo;

	@TableField("strategy")
	@ApiModelProperty("营销策略")
	private String strategy;

	@TableField("discount_info")
	@ApiModelProperty("营销策略")
	private String discountInfo;

	public Double getMaxReduceMoney(){
		double maxReduceMoney = this.maxReduceMoney==null? 0 :this.maxReduceMoney/100;
		return maxReduceMoney;
	}
	public Double getMinDiscount(){
		double minDiscount = this.minDiscount == null ? 0 : (100-this.minDiscount);
		return minDiscount;
	}
	
}

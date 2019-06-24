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

@Data
@ApiModel("店铺活动")
@TableName("keguan_activity")
@EqualsAndHashCode(callSuper = true)
public class KeguanActivity extends BaseModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@TableId(value = "activityid", type = IdType.AUTO)
	@ApiModelProperty("主键ID")
	private Long activityId;

	@TableField("merchantid")
	@ApiModelProperty("商户ID")
	private Integer merchantId;

	@TableField("wxid")
	@ApiModelProperty("wxId")
	private Integer wxId;

	@TableField("createtime")
	@ApiModelProperty("")
	private Date createTime;

	@TableField("updatetime")
	@ApiModelProperty("updatetime")
	private Date updateTime;

	@TableField("actype")
	@ApiModelProperty("活动类型(1：疯狂红包,2支付后领奖，3跟随推荐,4支付即会员,5会员卡分享,6领券得现金，7、Q11拉新活动,8本地最新活动，9本地热门活动)")
	private Integer acType;

	@TableField("begintime")
	@ApiModelProperty("活动开始时间")
	private Date beginTime;

	@TableField("endtime")
	@ApiModelProperty("活动结束时间")
	private Date endTime;

	@TableField("acstatus")
	@ApiModelProperty("活动状态（1，已启动；0，已暂停；-1：已删除；2、已创建）")
	private Integer acStatus;

	@TableField("acpv")
	@ApiModelProperty("活动PV量(浏览量)")
	private Integer acPv;

	@TableField("acuv")
	@ApiModelProperty("活动UV量（访客量")
	private Integer acUv;

	@TableField("acjoinnum")
	@ApiModelProperty("活动参与人数")
	private Integer acJoinNum;

	@TableField("acforwardnum")
	@ApiModelProperty("活动转发人数")
	private String acForwardNum;

	@TableField("actitle")
	@ApiModelProperty("活动标题")
	private String acTitle;

	@TableField("sharedesc")
	@ApiModelProperty("公众号分享描述")
	private String shareDesc;

	@TableField("sharepic")
	@ApiModelProperty("公众号分享图标")
	private String sharePic;

	@TableField("cardid")
	@ApiModelProperty("优惠券CardId")
	private String cardId;

	@TableField("giftway")
	@ApiModelProperty("赠送方式（FIXED_RED_PACKET：固定红包；RANDOM_RED_PACKET：随机红包；CARD_BALANCE 会员卡余额;CARD_POINT会员卡积分;PLATFORM_RED_PACKET平台红包）")
	private String giftWay;

	@TableField("barfrontcolor")
	@ApiModelProperty("小程序前景颜色值")
	private String barFrontColor;

	@TableField("bartitle")
	@ApiModelProperty("小程序页面标题")
	private String barTitle;

	@TableField("barbackgroundcolor")
	@ApiModelProperty("小程序背景颜色值")
	private String barBackGroundColor;

	@TableField("appsharetitle")
	@ApiModelProperty("小程序分享标题")
	private String appShareTitle;

	@TableField("appshareimageurl")
	@ApiModelProperty("小程序分享自定义图片路径")
	private String appShareImageUrl;

	@TableField("backgroundpic")
	@ApiModelProperty("背景图")
	private String backgroundPic;

	@TableField("introduct")
	@ApiModelProperty("活动说明（富文本说明）")
	private String introduct;

	@TableField("acmoney")
	@ApiModelProperty("活动金额")
	private Double acMoney;

	@TableField("xcxqrcode")
	@ApiModelProperty("小程序二维码")
	private String xcxQrcode;

	@TableField("xcxurl")
	@ApiModelProperty("小程序链接")
	private String xcxUrl;

	@TableField("gzhqrcode")
	@ApiModelProperty("公众号二维码")
	private String gzhQrcode;

	@TableField("gzhurl")
	@ApiModelProperty("公众号链接")
	private String gzhUrl;

	@TableField("congralanguage")
	@ApiModelProperty("领取红包祝福语")
	private String congraLanguage;

	@TableField("couponiconground")
	@ApiModelProperty("立即领券按钮背景图")
	private String couponIconGround;

	@TableField("rreporticonground")
	@ApiModelProperty("转发好友按钮背景图")
	private String rreportIconGround;

	@TableField("friendscircleground")
	@ApiModelProperty("分享到朋友圈按钮背景图")
	private String friendsCircleGround;

	@TableField("frontbgcolor")
	@ApiModelProperty("背景色")
	private String frontBgColor;

	@TableField("navibarcolor")
	@ApiModelProperty("导航栏颜色")
	private String naviBarColor;

	@TableField("shopids")
	@ApiModelProperty("对应门店Id，多个，分割")
	private String shopIds;

	@TableField("tuijian")
	@ApiModelProperty("推荐状态")
	private Integer tuijian;

	@TableField("sort")
	@ApiModelProperty("sort")
	private Integer sort;

	@TableField("coverimg")
	@ApiModelProperty("推荐活动封面图")
	private String coverImg;

	@TableField("openorclose")
	@ApiModelProperty("开关按钮（1开。0关）")
	private Integer openOrClose;

	@TableField("withdrawalrules")
	@ApiModelProperty("提现规则")
	private String withdrawalRules;

	@TableField("meetcardgroup")
	@ApiModelProperty("满赠优惠券组")
	private String meetCardGroup;

	@TableField("firstopenpacket")
	@ApiModelProperty("首开红包")
	private String firstOpenPacket;

}

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

import java.math.BigDecimal;
import java.util.Date;

@Data
@ApiModel("微信优惠券")
@TableName("keguan_wxcardinfo")
@EqualsAndHashCode(callSuper = true)
public class KeguanWxcardinfo extends BaseModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@TableId(type = IdType.AUTO)
	private Long id;

	@TableField("cardid")
	@ApiModelProperty("")
	private String cardId;

	@TableField("wxid")
	@ApiModelProperty("")
	private Long wxid;

	@TableField("merchantid")
	@ApiModelProperty("")
	private Long merchantId;

	@TableField("cardtype")
	@ApiModelProperty("GROUPON  团购券类型。\n" +
			"CASH  代金券类型。\n" +
			"DISCOUNT  折扣券类型。\n" +
			"GIFT  兑换券类型。\n" +
			"GENERAL_COUPON  优惠券")
	private String cardType;

	@TableField("cardstatus")
	@ApiModelProperty("状态")
	private String cardStatus;

	@TableField("cardnumber")
	@ApiModelProperty("可领数量")
	private Integer cardNumber;

	@TableField("discount")
	@ApiModelProperty("打折")
	private BigDecimal discount;

	@TableField("reduce_money")
	@ApiModelProperty("抵扣现金(积分抵扣或代金券)")
	private BigDecimal reduceMoney;

	@TableField("least_money_to_use")
	@ApiModelProperty("抵扣条件，满xx元可用。  ")
	private BigDecimal leastMoneyToUse;

	@TableField("max_increase_bonus")
	@ApiModelProperty("用户单次可获取的积分上限")
	private Long maxIncreaseBonus;

	@TableField("title")
	@ApiModelProperty("标题")
	private String title;

	@TableField("brand_name")
	@ApiModelProperty("品牌名")
	private String brandName;

	@TableField("logo")
	@ApiModelProperty("logo")
	private String Logo;

	@TableField("total_quantity")
	@ApiModelProperty("发行总数")
	private Integer totalQuantity;

	@TableField("date_type")
	@ApiModelProperty("DATE_TYPE_FIX_TIME_RANGE 表示固定日期区间，DATE_TYPE_FIX_TERM表示固定时长（自领取后按天算")
	private String dateType;

	@TableField("begintime")
	@ApiModelProperty("DATE_TYPE_FIX_TIME_RANGE时专用，表示起用时间。从1970年1月1日00:00:00至起用时间的秒数，最终需转换为字符串形态传入。（东八区时间，单位为秒）")
	private Date beginTime;

	@TableField("endtime")
	@ApiModelProperty("表示结束时间，建议设置为截止日期的23:59:59过期。（东八区时间，单位为秒）")
	private Date endTime;

	@TableField("fixed_term")
	@ApiModelProperty("type为DATE_TYPE_FIX_TERM时专用，表示自领取后多少天内有效，不支持填写0。")
	private Long fixedTerm;

	@TableField("fixed_begin_term")
	@ApiModelProperty("type为DATE_TYPE_FIX_TERM时专用，表示自领取后多少天开始生效，领取后当天生效填写0。（单位为天）")
	private Long fixedBeginTerm;

	@TableField("cardjson")
	@ApiModelProperty("卡券json")
	private String cardJson;

	@TableField("createtime")
	@ApiModelProperty("创建时间")
	private Date createTime;

	@TableField("qrcodeurl")
	@ApiModelProperty("领取卡券二维码")
	private String qrcodeUrl;

	@TableField("qrcodeexprietime")
	@ApiModelProperty("领取卡券二维码过期时间")
	private Date qrCodeExprieTime;

	@TableField("tuijian")
	@ApiModelProperty("推荐到智店列表,数字大的排前面")
	private Long tuijian;

	@TableField("shopids")
	@ApiModelProperty("门店ids，用,分隔")
	private String shopIds;

	@TableField("activateuserform")
	@ApiModelProperty("会员卡激活表单")
	private String activateUserForm;

	@TableField("submid")
	@ApiModelProperty("代制子商户id")
	private Long subMid;

	@TableField(exist = false)
	@ApiModelProperty("是否可领取")
	private Boolean allowToReceive = true;
	
	@TableField(exist = false)
	@ApiModelProperty("条件")
	private String condition;
	
	@TableField(exist = false)
	@ApiModelProperty("可用时间")
	private String usable;

	@TableField(exist = false)
	@ApiModelProperty("当前用户卡卷")
	private KeguanWxusercard wxUserCard;

	@TableField(exist = false)
	@ApiModelProperty("当前店铺")
	private String shopName;

	@TableField(exist = false)
	@ApiModelProperty("wxCardUrl")
	private String wxCardUrl;

	public BigDecimal getDiscount() {
		Integer discount = this.discount==null?null:(100-this.discount.intValue());
		return BigDecimal.valueOf(discount);
	}

	public BigDecimal getReduceMoney() {
		BigDecimal reduceMoney = this.reduceMoney==null?null:this.reduceMoney.divide(new BigDecimal("100"));
		return reduceMoney;
	}

	public BigDecimal getLeastMoneyToUse() {
		BigDecimal leastMoneyToUse = this.leastMoneyToUse==null?null:this.leastMoneyToUse.divide(new BigDecimal("100"));
		return leastMoneyToUse;
	}

}

package com.reactx.selection.models.data.local;

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
@ApiModel("已领取券")
@TableName("keguan_wxusercard")
@EqualsAndHashCode(callSuper = true)
public class KeguanWxusercard extends BaseModel {
	/**
	* 
	*/
	private static final long serialVersionUID = 1L;

	@TableId(type = IdType.AUTO)
	private Long id;

	@ApiModelProperty("卡号")
	private String code;

	@ApiModelProperty("微信卡券id")
	private String cardid;

	@ApiModelProperty("领取人openid")
	private String openid;

	@ApiModelProperty("有效期开始时间")
	private Date begintime;

	@ApiModelProperty("有效期结束时间")
	private Date endtime;

	@ApiModelProperty("当前code对应卡券的状态NORMAL 正常,CONSUMED 已核销,EXPIRE 已过期, GIFTING 转赠中,GIFT_TIMEOUT 转赠超时 DELETE,已删除UNAVAILABLE,已失效 code未被添加或被转赠领取的情况则统一报错：invalid erial code")
	private String status;

	@ApiModelProperty("领取人userid")
	private Long userid;

	@ApiModelProperty("")
	private Long wxid;

	@ApiModelProperty("领取渠道")
	private String outerid;

	@ApiModelProperty("旧卡券code")
	private String oldusercardcode;

	@ApiModelProperty("领取时间")
	private Date gettime;

	@ApiModelProperty("使用时间")
	private Date usedtime;

	@ApiModelProperty("删除时间")
	private Date deletedtime;

	@ApiModelProperty("核销来源。支持开发者统计API核销（FROM_API）、公众平台核销（FROM_MP）、卡券商户助手核销（FROM_MOBILE_HELPER）（核销员微信号）")
	private String consumesource;

	@ApiModelProperty("交易流水号")
	private String outtradeno;

	@ApiModelProperty("微信支付交易订单号（只有使用买单功能核销的卡券才会出现）")
	private String transid;

	@ApiModelProperty("门店名称，当前卡券核销的门店名称（只有通过卡券商户助手和买单核销时才会出现）")
	private String locationid;

	@ApiModelProperty("核销该卡券核销员的openid（只有通过卡券商户助手核销时才会出现）")
	private String staffopenid;

	@ApiModelProperty("实付金额")
	private BigDecimal fee;

	@ApiModelProperty("应付金额")
	private BigDecimal originalfee;

	@ApiModelProperty("邀请领取用户")
	private String parentuserid;

	@ApiModelProperty("小程序OpenId")
	private String wxappopenid;

}

package com.reactx.selection.models.data.index;

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
@ApiModel("")
@TableName("ims_seller")
@EqualsAndHashCode(callSuper = true)
public class ImsSeller extends BaseModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@ApiModelProperty("主键ID(店铺ID)")
	@TableId(type = IdType.AUTO)
	private Long id;

	@ApiModelProperty("用户类型 1 买家用户 2 卖家用户")
	private Integer type;

	@ApiModelProperty("卖家用户的userid")
	private Integer userid;

	@ApiModelProperty("推荐人的ID")
	private Long parentid;

	@ApiModelProperty("店主的上级路径")
	private String prepath;

	@ApiModelProperty("卖家用户的openid")
	private String openid;

	@ApiModelProperty("卖家用户的淘宝联盟渠道id")
	private String relation_id;

	@ApiModelProperty("unionId")
	private String unionId;
	
	@ApiModelProperty("卖家等级")
	private Long sellerlevel;

	@ApiModelProperty("卖家用户的手机号码")
	private String mobile;

	@ApiModelProperty("卖家用户店铺名称")
	private String merchname;

	@ApiModelProperty("卖家用户的头像")
	private String headimgurl;

	@ApiModelProperty("登录密码")
	private String pwd;

	@ApiModelProperty("盐值")
	private String salt;

	@ApiModelProperty("是否删除 0 不是 1是默认0")
	private Integer status;

	@ApiModelProperty("用户的积分")
	private BigDecimal credit1;

	@ApiModelProperty("用户的福钻余额")
	private BigDecimal credit2;

	@ApiModelProperty("用户累积获取的福钻")
	private BigDecimal credit3;

	@ApiModelProperty("用户昨日收益")
	private BigDecimal credit4;

	@ApiModelProperty("用户的上月收益")
	private BigDecimal credit5;

	@ApiModelProperty("纳新总收益")
	private BigDecimal credit6;

	@ApiModelProperty("销售预估总收益")
	private BigDecimal credit7;

	@ApiModelProperty("真正销售收益")
	private BigDecimal credit8;

	@ApiModelProperty("是否签到 0 未签到  1 已签到")
	private Integer issign;

	@ApiModelProperty("每天发放的福钻")
	private BigDecimal credit9;

	@ApiModelProperty("用户分享素材获取的福气")
	private BigDecimal credit10;

	@ApiModelProperty("卖家用户邀请码")
	private String requestcode;

	@ApiModelProperty("店主现在拥有的端口")
	private Integer ports;

	@ApiModelProperty("直推推客人数")
	private Integer nexttwitter;

	@ApiModelProperty("直推经理人数")
	private Integer nextmanager;

	@ApiModelProperty("下级直推总监人数")
	private Integer nextnum;

	@ApiModelProperty("用户性别 1 为男性 2 为女性 默认为0")
	private Integer sex;

	@ApiModelProperty("用户所在省")
	private String province;

	@ApiModelProperty("用户所在市")
	private String city;

	@ApiModelProperty("下级团队人数")
	private Integer junior;

	@ApiModelProperty("用户的真实姓名")
	private String realname;

	@ApiModelProperty("用户的真实姓名")
	private String real;

	@ApiModelProperty("用户的身份证号")
	private String card;

	@ApiModelProperty("用户的支付宝帐号")
	private String alipay;

	@ApiModelProperty("用户的支付宝绑定的手机号")
	private String alipayphone;

	@ApiModelProperty("code的ID")
	private Integer acid;

	@ApiModelProperty("用户广告位ID")
	private String adzoneid;

	@ApiModelProperty("app的ID")
	private String siteid;

	@ApiModelProperty("完成开店时间")
	private Integer finishtime;

	@ApiModelProperty("1--锁定,0--未锁定")
	private Integer lock;

	@ApiModelProperty("用户的微信号")
	private String weixin;
	/*-------------------------------------------------@虚无缥缈新增---------------------------------------------------*/

	@ApiModelProperty("创建时间")
	@TableField("create_time")
	private Date createTime;
	
	@ApiModelProperty("余额")
	private BigDecimal balance;

	@ApiModelProperty("累计结算")
	private BigDecimal sumSettlement;

	@ApiModelProperty("累计提现")
	private BigDecimal sumWithdrawDeposit;

	@ApiModelProperty("上月结算")
	private BigDecimal lastMonthSettlement;

	@ApiModelProperty("上月预估")
	private BigDecimal lastMonthForecast;

	@ApiModelProperty("本月预估")
	private BigDecimal thisMonthForecast;

	@ApiModelProperty("昨日付款笔数")
	private Integer yesterdayPayNum;

	@ApiModelProperty("昨日预估")
	private BigDecimal yesterdayForecast;

	@ApiModelProperty("昨日其他")
	private BigDecimal yesterdayRests;

	@ApiModelProperty("今日付款笔数")
	private Integer todayPayNum;

	@ApiModelProperty("今日预估")
	private BigDecimal todayForecast;

	@ApiModelProperty("今日其他")
	private BigDecimal todayRests;

	@ApiModelProperty("累计预估")
	private BigDecimal sumForecast;

	@ApiModelProperty("券金")
	@TableField("quan_gold")
	private BigDecimal couponKing;

	@ApiModelProperty("券力")
	@TableField("quan_power")
	private BigDecimal couponForce;

	@ApiModelProperty("本周签到天数")
	private Integer continuousDay;

	@ApiModelProperty("上次签到时间")
	private Date lastSignInDay;

	@ApiModelProperty("标签")
	private String tags;
	
	@ApiModelProperty("推荐可获得券力总值")
	private Integer sumRecommend;
	
	@ApiModelProperty("来源")
	private Integer registeredSource;
	
	@ApiModelProperty("用户标识")
	private String userKey;
	
	@ApiModelProperty("")
	private String wechatid;
	
	@ApiModelProperty("等级")
	@TableField(exist = false)
	private SysUserGrade grade;

}

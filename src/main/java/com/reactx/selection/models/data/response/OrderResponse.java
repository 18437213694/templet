package com.reactx.selection.models.data.response;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
@ApiModel("用户资料订单信息")
public class OrderResponse implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @ApiModelProperty("订单号")
    private String orderNum;

    @ApiModelProperty("是否结算 0 预估未结算 1 已结算预估自购返佣 2已预估奖励收入 3 结算金额")
    private Integer issettle;

    @ApiModelProperty("类目")
    private String category;

    @ApiModelProperty("商品id")
    private String numiid;

    @ApiModelProperty("创建时间")
    private Date createTime;

    @ApiModelProperty("付款金额")
    private BigDecimal payMoney;

    @ApiModelProperty("预估佣金")
    private String estimateMoney;

    @ApiModelProperty("订单状态订单状态 0 订单失效 1 订单付款 2 订单结算 3 订单成功")
    private Integer orderstatus;

    @ApiModelProperty("平台  1--淘宝  2--拼多多 3--京东")
    private Integer platform;

    @ApiModelProperty("用户昵称")
    private String nick;

}

package com.reactx.selection.models.data.response;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@ApiModel("群基础信息")
public class GroupDataResponse implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @ApiModelProperty("群累计交易量")
    private String groupSumTransaMoney;

    @ApiModelProperty("群待结算佣金")
    private String groupNoSettleMoney;

    @ApiModelProperty("群累计结算佣金")
    private String groupSettleMoney;

    @ApiModelProperty("群付款笔数")
    private Long groupPayNum;

    @ApiModelProperty("群付款金额")
    private String groupPayMoney;

    @ApiModelProperty("群退款笔数")
    private Long groupRefundNum;

    @ApiModelProperty("群退款金额")
    private String groupRefundMoney;

    @ApiModelProperty("订单数量")
    private Long groupOrderSum;

    @ApiModelProperty("创建时间")
    private Date createTime;

    @ApiModelProperty("订单记录")
    private List<OrderResponse> groupOrders;
}

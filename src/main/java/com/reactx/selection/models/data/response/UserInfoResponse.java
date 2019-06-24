package com.reactx.selection.models.data.response;


import com.mysql.cj.x.protobuf.MysqlxCrud;
import com.reactx.selection.models.data.index.HDKCircleOfFriends;
import com.reactx.selection.models.data.index.ImsTaobaoOrder;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
@ApiModel("用户基础信息")
public class UserInfoResponse implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @ApiModelProperty("邀请人")
    private String requestName;

    @ApiModelProperty("等级")
    private String level;

    @ApiModelProperty("团队人数")
    private Long teamSum;

    @ApiModelProperty("创建时间")
    private Date createTime;

    @ApiModelProperty("待结算佣金")
    private String noSettleMoney;

    @ApiModelProperty("总结算佣金")
    private String settledMoney;

    @ApiModelProperty("付款笔数")
    private Long payNum;

    @ApiModelProperty("付款金额")
    private String payMoney;

    @ApiModelProperty("退款笔数")
    private Long refundNum;

    @ApiModelProperty("退款金额")
    private String refundMoney;

    @ApiModelProperty("订单数量")
    private Long orderSum;

    @ApiModelProperty("订单记录")
    private List<OrderResponse> orders;
}

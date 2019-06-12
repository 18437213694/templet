package com.reactx.selection.models.data.index;

import com.reactx.selection.models.base.BaseModel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;


@Data
@ApiModel("用户资料")
public class UserIndex extends BaseModel {



    @ApiModelProperty("名称")
    private String name;

    @ApiModelProperty("用户等级id")
    private Integer levelid;

    @ApiModelProperty("邀请人")
    private String inviter;

    @ApiModelProperty("团队人数")
    private String teamCount;

    @ApiModelProperty("待结算佣金")
    private String toBeSettled;

    @ApiModelProperty("累计结算佣金")
    private String alreadySettled;

    @ApiModelProperty("付款笔数")
    private String payCount;

    @ApiModelProperty("付款金额")
    private String payMoney;

    @ApiModelProperty("退款笔数")
    private String refundCount;

    @ApiModelProperty("退款金额")
    private String refundMoney;

    @ApiModelProperty("订单列表(默认10条记录)")
    private List orderList;

}

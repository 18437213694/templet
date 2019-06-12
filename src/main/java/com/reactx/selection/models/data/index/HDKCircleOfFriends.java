package com.reactx.selection.models.data.index;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel("好单库朋友圈API")
public class HDKCircleOfFriends implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @ApiModelProperty("单品id")
    private String edit_id;

    @ApiModelProperty("宝贝id")
    private String itemid;

    @ApiModelProperty("多张宝贝图片，含实拍图")
    private String itempic;

    @ApiModelProperty("宝贝标题")
    private String itemtitle;

    @ApiModelProperty("优惠券链接")
    private String couponurl;

    @ApiModelProperty("单品导购内容（表情未处理）")
    private String content;

    @ApiModelProperty("朋友圈评论内容（表情未处理），多条评论用“|”做区分")
    private String comment;

    @ApiModelProperty("展示时间戳")
    private String show_time;

    @ApiModelProperty("宝贝券后价")
    private String itemendprice;

    @ApiModelProperty("优惠券金额")
    private String couponmoney;

    @ApiModelProperty("该商品被分享次数")
    private String dummy_click_statistics;

    @ApiModelProperty("在售价")
    private String itemprice;

    @ApiModelProperty("佣金比例")
    private String tkrates;

    @ApiModelProperty("导购文案展示内容，含表情")
    private String show_content;

    @ApiModelProperty("导购文案复制内容，含表情")
    private String copy_content;

    @ApiModelProperty("朋友圈评论展示内容，含表情，多条评论用“|”做区分")
    private String show_comment;

    @ApiModelProperty("朋友圈评论复制内容，含表情，多条评论用“|”做区分")
    private String copy_comment;

}

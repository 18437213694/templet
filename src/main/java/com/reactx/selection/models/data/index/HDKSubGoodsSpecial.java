package com.reactx.selection.models.data.index;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel("好货专场")
public class HDKSubGoodsSpecial implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @ApiModelProperty("自增ID")
    private String product_id;

    @ApiModelProperty("宝贝ID")
    private String itemid;

    @ApiModelProperty("宝贝标题")
    private String itemtitle;

    @ApiModelProperty("宝贝短标题")
    private String itemshorttitle;

    @ApiModelProperty("宝贝推荐语")
    private String itemdesc;

    @ApiModelProperty("在售价")
    private String itemprice;

    @ApiModelProperty("宝贝月销量")
    private String itemsale;

    @ApiModelProperty("宝贝近2小时跑单")
    private String itemsale2;

    @ApiModelProperty("当天销量")
    private String todaysale;

    @ApiModelProperty("宝贝主图原始图像（由于图片原图过大影响加载速度，建议加上后缀_310x310.jpg，如https://img.alicdn.com/imgextra/i2/3412518427/TB26gs7bb7U5uJjSZFFXXaYHpXa_!!3412518427.jpg_310x310.jpg）")
    private String itempic;

    @ApiModelProperty("推广长图（带http://img.haodanku.com/0_553757100845_1509175123.jpg-600进行访问）")
    private String itempic_copy;

    @ApiModelProperty("商品类目：\n" +
            "1女装，2男装，3内衣，4美妆，5配饰，6鞋品，7箱包，8儿童，9母婴，10居家，11美食，12数码，13家电，14其他，15车品，16文体，17宠物")
    private String fqcat;

    @ApiModelProperty("宝贝券后价")
    private String itemendprice;

    @ApiModelProperty("店铺类型：\n" +
            "天猫店（B）\n" +
            "淘宝店（C）")
    private String shoptype;

    @ApiModelProperty("优惠券链接")
    private String couponurl;

    @ApiModelProperty("优惠券金额")
    private String couponmoney;

    @ApiModelProperty("商品视频ID（id大于0的为有视频单，视频拼接地址http://cloud.video.taobao.com/play/u/1/p/1/e/6/t/1/+videoid+.mp4）")
    private String videoid;

    @ApiModelProperty("活动类型：\n" +
            "普通活动\n" +
            "聚划算\n" +
            "淘抢购")
    private String activity_type;

    @ApiModelProperty("营销计划链接")
    private String planlink;

    @ApiModelProperty("佣金比例")
    private String tkrates;

    @ApiModelProperty("预计可得（宝贝价格 * 佣金比例 / 100）")
    private String tkmoney;

    @ApiModelProperty("优惠券开始时间")
    private String couponstarttime;

    @ApiModelProperty("优惠券结束时间")
    private String couponendtime;


}

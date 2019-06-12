package com.reactx.selection.models.data.index;


import com.google.gson.annotations.SerializedName;
import com.reactx.selection.models.base.BaseModel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


@Data
@ApiModel("好单库商品")
public class HaoDanKuProduct extends BaseModel {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @ApiModelProperty("自增ID")
//    @SerializedName("productId")
    private String product_id;

    @ApiModelProperty("宝贝ID")
    private String itemid;

    @ApiModelProperty("宝贝标题")
    private String itemtitle;

    @ApiModelProperty("宝贝短标题")
    private String itemshorttitle;

    @ApiModelProperty("宝贝推荐语")
    @SerializedName("productId")
    private String itemdesc;

    @ApiModelProperty("在售价")
    private String itemprice;

    @ApiModelProperty("宝贝月销量")
    private String itemsale;

    @ApiModelProperty("宝贝近2小时跑单")
    private String itemsale2;

    @ApiModelProperty("宝贝主图原始图像（由于图片原图过大影响加载速度，建议加上后缀_310x310.jpg")
    private String itempic;

    @ApiModelProperty("推广长图")
    private String itempic_copy;

    @ApiModelProperty("商品类目：1女装，2男装，3内衣，4美妆，5配饰，6鞋品，7箱包，8儿童，9母婴，10居家，11美食，12数码，13家电，14其他，15车品，16文体，17宠物")
    private String fqcat;

    @ApiModelProperty("宝贝券后价")
    private String itemendprice;

    @ApiModelProperty("店铺类型：天猫店（B）淘宝店（C）")
    private String shoptype;

    @ApiModelProperty("优惠券链接")
    private String couponurl;

    @ApiModelProperty("优惠券金额")
    private String couponmoney;

    @ApiModelProperty("是否为品牌产品（1是）")
    private String is_brand;

    @ApiModelProperty("是否为直播（1是）")
    private String is_live;

    @ApiModelProperty("当天销量")
    private String todaysale;

    @ApiModelProperty("推广导购文案")
    private String guide_article;

    @ApiModelProperty("商品视频ID（id大于0的为有视频单，视频拼接地址http://cloud.video.taobao.com/play/u/1/p/1/e/6/t/1/+videoid+.mp4）")
    private String videoid;

    @ApiModelProperty("活动类型：普通活动 聚划算 淘抢购")
    private String activity_type;

    @ApiModelProperty("营销计划链接")
    private String planlink;

    @ApiModelProperty("店主的userid")
    private String userid;

    @ApiModelProperty("店铺掌柜名")
    private String sellernick;

    @ApiModelProperty("店铺名")
    private String shopname;

    @ApiModelProperty("佣金计划：隐藏 营销")
    private String tktype;

    @ApiModelProperty("佣金比例")
    private String tkrates;

    @ApiModelProperty("是否村淘（1是）")
    private String cuntao;

    @ApiModelProperty("预计可得（宝贝价格 * 佣金比例 / 100）")
    private String tkmoney;

    @ApiModelProperty("当天优惠券领取量")
    private String couponreceive2;

    @ApiModelProperty("优惠券剩余量")
    private String couponsurplus;

    @ApiModelProperty("优惠券总数量")
    private String couponnum;

    @ApiModelProperty("优惠券使用条件")
    private String couponexplain;

    @ApiModelProperty("优惠券开始时间")
    private String couponstarttime;

    @ApiModelProperty("优惠券结束时间")
    private String couponendtime;

    @ApiModelProperty("活动开始时间")
    private String start_time;

    @ApiModelProperty("活动结束时间")
    private String end_time;

    @ApiModelProperty("发布时间")
    private String starttime;

    @ApiModelProperty("举报处理条件:0未举报 1为待处理 2为忽略 3为下架")
    private String report_status;

    @ApiModelProperty("好单指数")
    private String general_index;

    @ApiModelProperty("放单人名号")
    private String seller_name;

    @ApiModelProperty("折扣力度")
    private String discount;


}

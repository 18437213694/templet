package com.reactx.selection.models.data.index;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel("好货专场")
public class HDKSpecialTheme implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @ApiModelProperty("专题id，用于在下一个接口获取专题的商品")
    private String id;

    @ApiModelProperty("专题的标题")
    private String name;

    @ApiModelProperty("专题banner（正方形图）,图片拼接地址如：http://img.haodanku.com/FlfXRXa3NK68Qy8Kvj_QscpMp3xw-600")
    private String image;

    @ApiModelProperty("专题banner（长方形有弧度图）,图片拼接地址如：http://img.haodanku.com/FosY6Szk5scmidEkK6tzIqMRM4kR-600")
    private String app_image;

    @ApiModelProperty("专题banner（长方形无弧度图）,图片拼接地址如：http://img.haodanku.com/FhqJGdrTkCzI56350Ews0zEkMwBT-600")
    private String cms_image;

    @ApiModelProperty("专题的介绍文案题")
    private String content;

    @ApiModelProperty("专场开始时间戳")
    private String activity_start_time;

    @ApiModelProperty("专场结束时间戳")
    private String activity_end_time;


}

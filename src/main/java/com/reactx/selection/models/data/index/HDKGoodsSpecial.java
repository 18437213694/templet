package com.reactx.selection.models.data.index;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@ApiModel("好货专场")
public class HDKGoodsSpecial implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @ApiModelProperty("专场id")
    private String subject_id;

    @ApiModelProperty("专场短标题")
    private String name;

    @ApiModelProperty("专场导购内容")
    private String content;

    @ApiModelProperty("导购文案展示内容，含表情")
    private String show_text;

    @ApiModelProperty("导购文案复制内容，含表情")
    private String copy_text;

    @ApiModelProperty("专场商品被分享次数")
    private String share_times;

    @ApiModelProperty("专场开始时间戳")
    private String activity_start_time;

    @ApiModelProperty("专场结束时间戳")
    private String activity_end_time;


    @ApiModelProperty("宝贝列表")
    private List<HDKSubGoodsSpecial> item_data;


}

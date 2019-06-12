package com.reactx.selection.models.data.index;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@ApiModel("超值大牌")
public class HDKBrand implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @ApiModelProperty("品牌id")
    private String id;

    @ApiModelProperty("淘宝品牌名称")
    private String tb_brand_name;

    @ApiModelProperty("蜂擎品牌名称")
    private String fq_brand_name;

    @ApiModelProperty("品牌logo")
    private String brand_logo;

    @ApiModelProperty("内页logo")
    private String inside_logo;

    @ApiModelProperty("品牌类目")
    private String brandcat;

    @ApiModelProperty("品牌简介")
    private String introduce;

    @ApiModelProperty("宝贝列表")
    private List<HaoDanKuProduct> item;


}

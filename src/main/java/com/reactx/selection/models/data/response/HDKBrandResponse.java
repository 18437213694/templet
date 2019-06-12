package com.reactx.selection.models.data.response;

import com.reactx.selection.models.data.index.HDKBrand;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@ApiModel("品牌列表")
public class HDKBrandResponse implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @ApiModelProperty("状态码（1成功，0失败或没有数据返回）")
    private String code;

    @ApiModelProperty("作为请求地址中获取下一页的参数值")
    private String min_id;

    @ApiModelProperty("返回信息说明，SUCCESS代表成功获取，失败则有具体原因")
    private String msg;

    @ApiModelProperty("品牌信息")
    private List<HDKBrand> data;

}

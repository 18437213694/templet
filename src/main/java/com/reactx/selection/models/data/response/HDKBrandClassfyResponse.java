package com.reactx.selection.models.data.response;

import com.reactx.selection.models.data.index.TodayClassify;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

;

@Data
@ApiModel("品牌热销下发")
public class HDKBrandClassfyResponse implements Serializable {

    @ApiModelProperty("返回信息说明，SUCCESS代表成功获取，失败则有具体原因")
    private String images;

    @ApiModelProperty("品牌信息")
    private List<TodayClassify> brandClassfy;

}

package com.reactx.selection.models.data.index;


import com.reactx.selection.models.base.BaseModel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
@ApiModel("24小时热销分类")
public class TodayClassify extends BaseModel {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @ApiModelProperty("分类id")
    private Integer id;

    @ApiModelProperty("分类name")
    private String name;

}

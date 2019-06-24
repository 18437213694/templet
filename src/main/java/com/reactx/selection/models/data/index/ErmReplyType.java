package com.reactx.selection.models.data.index;


import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.reactx.selection.models.base.BaseModel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


@Data
@TableName("erm_reply_type")//表名
@ApiModel("快速回复类型表")
public class ErmReplyType extends BaseModel {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @TableField("id")
    @TableId(type= IdType.AUTO)
    @ApiModelProperty("主键id")
    private Integer id;

    @TableField("t_name")
    @ApiModelProperty("名称")
    private String tName;

}

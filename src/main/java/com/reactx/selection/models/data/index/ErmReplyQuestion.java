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
@TableName("erm_reply_question")//表名
@ApiModel("快速回复问题")
public class ErmReplyQuestion extends BaseModel {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @TableField("id")
    @TableId(type= IdType.AUTO)
    @ApiModelProperty("主键id")
    private Integer id;

    @TableField("q_name")
    @ApiModelProperty("名称")
    private String qName;

}

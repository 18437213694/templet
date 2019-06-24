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
@TableName("erm_reply")//表名
@ApiModel("快速回复")
public class ErmReply extends BaseModel {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @TableField("id")
    @TableId(type= IdType.AUTO)
    @ApiModelProperty("主键id")
    private Integer id;

    @TableField("question_id")
    @ApiModelProperty("问题id")
    private Long questionId;

    @TableField("content")
    @ApiModelProperty("内容")
    private String content;

    @TableField("type_id")
    @ApiModelProperty("类型id")
    private Integer typeId;

    @TableField("wechatid")
    @ApiModelProperty("微信id")
    private String wechatid;

    @TableField(exist = false)
    @ApiModelProperty("话术类型")
    private String t_name;

    @TableField(exist = false)
    @ApiModelProperty("问题")
    private String q_name;
}

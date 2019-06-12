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
@TableName("erm_reply_group")//表名
@ApiModel("快速回复分组")
public class ErmReplyGroup extends BaseModel {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @TableField("id")
    @TableId(type= IdType.AUTO)
    @ApiModelProperty("主键id")
    private Integer id;

    @TableField("group_name")
    @ApiModelProperty("分组名称")
    private String groupName;

    @TableField("class_id")
    @ApiModelProperty("类别id:1,企业话术 2,个人话术")
    private String classId;

    @TableField("wechat_id")
    @ApiModelProperty("个人话术关联微信id")
    private String wechatId;


}

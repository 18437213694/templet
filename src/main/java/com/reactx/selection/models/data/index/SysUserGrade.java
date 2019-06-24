package com.reactx.selection.models.data.index;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.reactx.selection.models.base.BaseModel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

@Data
@ApiModel("用户等级")
@TableName("sys_user_grade")
@EqualsAndHashCode(callSuper=true)
public class SysUserGrade extends BaseModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@TableId(type= IdType.AUTO)
	private Long id;
	
	@ApiModelProperty("名称")
	private String name;
	
	@ApiModelProperty("图片链接")
	private String picUrl;
	
	@ApiModelProperty("创建时间")
	private Date createTime;
	
	

}

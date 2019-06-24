package com.reactx.selection.models.data.jingdong;

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
@ApiModel("分类")
@TableName("sys_index_classify")
@EqualsAndHashCode(callSuper = true)
public class SysIndexClassify extends BaseModel {
	/**
	* 
	*/
	private static final long serialVersionUID = 1L;

	@TableId(type = IdType.AUTO)
	private Long id;

	@ApiModelProperty("名称")
	private String name;

	@ApiModelProperty("值")
	private String value;

	@Deprecated
	@ApiModelProperty("推广位id")
	private Long favoritesId;

	@ApiModelProperty("背景图")
	private String bgImg;

	@ApiModelProperty("banner（用,分开）")
	private String images;

	@ApiModelProperty("排序")
	private Integer sort;

	@ApiModelProperty
	private GoodsClassType type;

	@ApiModelProperty("创建时间")
	private Date createTime;

}

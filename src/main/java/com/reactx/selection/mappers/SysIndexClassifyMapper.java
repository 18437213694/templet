package com.reactx.selection.mappers;

import com.reactx.selection.models.base.BaseMapper;
import com.reactx.selection.models.data.jingdong.SysIndexClassify;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface SysIndexClassifyMapper extends BaseMapper<SysIndexClassify> {

	@Select("SELECT name,value FROM sys_index_classify WHERE type = #{type} ORDER BY sort DESC")
	List<SysIndexClassify> querySysIndex(String type);
}

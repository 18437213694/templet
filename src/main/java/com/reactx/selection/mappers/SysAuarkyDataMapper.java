package com.reactx.selection.mappers;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.reactx.selection.models.data.pinduoduo.SysAutarkyData;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.math.BigDecimal;
import java.util.List;

public interface SysAuarkyDataMapper extends BaseMapper<SysAutarkyData> {
	List<SysAutarkyData> findPage(@Param("pageNo") Integer pageNo, @Param("pageSize") Integer pageSize,
								  @Param("keyword") String keyword, @Param("sortType") String sortType);

	Long getCount(@Param("pageNo") Integer pageNo, @Param("pageSize") Integer pageSize,
				  @Param("keyword") String keyword);
}

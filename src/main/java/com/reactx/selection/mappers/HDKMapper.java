package com.reactx.selection.mappers;

import org.apache.ibatis.annotations.Select;

public interface HDKMapper {

    @Select("select value from keguan_setting where name like #{name}")
    String getClassfy(String name);

}

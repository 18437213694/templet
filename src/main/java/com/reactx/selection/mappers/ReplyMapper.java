package com.reactx.selection.mappers;


import com.reactx.selection.models.base.BaseMapper;
import com.reactx.selection.models.data.index.ErmReply;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ReplyMapper extends BaseMapper<ErmReply> {


    @Select("select id,title,content,group_id groupId from erm_reply where group_id=#{groupId} order by creat_time desc")
    List<ErmReply> queryReply(Integer groupId);


    @Insert("insert into erm_reply values(null,#{title},#{content},#{groupId},NOW())")
    void insertReply(ErmReply ermReply);


}

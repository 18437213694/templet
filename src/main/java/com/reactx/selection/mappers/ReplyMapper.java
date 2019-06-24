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

//    @Select("select id,title,content,class_id classId,class_name className from erm_reply where (class_id = 1) or (class_id = 2 and wechatid=#{wechatid}) order by creat_time desc")
    @Select("SELECT t.t_name,q.q_name,e.content,e.question_id questionId,e.type_id typeId FROM erm_reply e,erm_reply_type t,erm_reply_question q WHERE e.question_id = q.id AND e.type_id=t.id AND " +
            "((t.id = 2) OR (t.id = 1 AND e.wechatid = #{wechatid})) ORDER BY e.creat_time DESC")
    List<ErmReply> queryAllReply(String wechatid);
}

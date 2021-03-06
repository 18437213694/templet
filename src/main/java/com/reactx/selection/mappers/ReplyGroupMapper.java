package com.reactx.selection.mappers;


import com.reactx.selection.models.base.BaseMapper;
import com.reactx.selection.models.data.index.ErmReplyType;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ReplyGroupMapper extends BaseMapper<ErmReplyType> {

    @Select("select id,group_name groupName,class_id classId,wechat_id wechatId from erm_reply_group where class_id=#{groupId} and wechat_id=#{wechatId} order by creat_time desc")
    List<ErmReplyType> querySubGroup(@Param("groupId") Integer groupId, @Param("wechatId") String wechatId);

    @Select("select id,group_name groupName,class_id classId,wechat_id wechatId from erm_reply_group where class_id=#{groupId} order by creat_time desc")
    List<ErmReplyType> querySupGroup(Integer groupId);

    @Insert("insert into erm_reply_group values(null,#{groupName},#{classId},#{wechatId},NOW())")
    void insertSubGroup(ErmReplyType ermReplyGroup);

}

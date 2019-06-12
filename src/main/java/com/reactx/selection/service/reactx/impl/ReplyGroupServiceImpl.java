package com.reactx.selection.service.reactx.impl;

import com.reactx.selection.mappers.ReplyGroupMapper;
import com.reactx.selection.models.base.BaseServiceImpl;
import com.reactx.selection.models.data.index.ErmReplyGroup;
import com.reactx.selection.service.reactx.ReplyGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReplyGroupServiceImpl extends BaseServiceImpl<ReplyGroupMapper, ErmReplyGroup> implements ReplyGroupService {

    @Autowired
    private ReplyGroupMapper replyGroupMapper;

    @Override
    public List<ErmReplyGroup> queryGroup(Integer groupId, String wechatId) {
        if(wechatId==null){
            return  replyGroupMapper.querySupGroup(groupId);
        }
        return replyGroupMapper.querySubGroup(groupId,wechatId);
    }

    @Override
    public void insertSubGroup(ErmReplyGroup ermReplyGroup) {
        ermReplyGroup.setId(null);
        replyGroupMapper.insertSubGroup(ermReplyGroup);
    }

}

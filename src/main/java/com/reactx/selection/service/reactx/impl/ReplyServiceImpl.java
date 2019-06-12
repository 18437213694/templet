package com.reactx.selection.service.reactx.impl;

import com.reactx.selection.mappers.ReplyMapper;
import com.reactx.selection.models.base.BaseServiceImpl;
import com.reactx.selection.models.data.index.ErmReply;
import com.reactx.selection.service.reactx.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReplyServiceImpl extends BaseServiceImpl<ReplyMapper, ErmReply> implements ReplyService {

    @Autowired
    private ReplyMapper replyMapper;


    @Override
    public List<ErmReply> queryReply(Integer subGroupId) {

        List<ErmReply> ermReplies = replyMapper.queryReply(subGroupId);
        return ermReplies;
    }


    @Override
    public void insertReply(ErmReply ermReply) {
        ermReply.setId(null);
        replyMapper.insertReply(ermReply);
    }
}

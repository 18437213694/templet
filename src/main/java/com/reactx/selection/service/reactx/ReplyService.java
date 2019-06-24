package com.reactx.selection.service.reactx;


import com.reactx.selection.models.base.BaseService;
import com.reactx.selection.models.data.index.ErmReply;

import java.util.List;

public interface ReplyService extends BaseService<ErmReply> {


    List<ErmReply> queryReply(Integer subGroupId);

    void insertReply(ErmReply ermReply);

    List<ErmReply> queryAllReply(String wechatid);
}

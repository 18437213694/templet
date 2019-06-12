package com.reactx.selection.service.reactx;


import com.reactx.selection.models.base.BaseService;
import com.reactx.selection.models.data.index.ErmReplyGroup;

import java.util.List;

public interface ReplyGroupService extends BaseService<ErmReplyGroup> {

    List<ErmReplyGroup> queryGroup(Integer groupId,String wechtId);

    void insertSubGroup(ErmReplyGroup ermReplyGroup);

}

package com.reactx.selection.service.reactx;


import com.reactx.selection.models.base.BaseService;
import com.reactx.selection.models.data.index.ErmReplyType;

import java.util.List;

public interface ReplyGroupService extends BaseService<ErmReplyType> {

    List<ErmReplyType> queryGroup(Integer groupId, String wechtId);

    void insertSubGroup(ErmReplyType ermReplyGroup);

}

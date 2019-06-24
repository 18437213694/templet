package com.reactx.selection.service.reactx;

import com.baomidou.mybatisplus.plugins.Page;
import com.reactx.selection.models.base.BaseService;
import com.reactx.selection.models.data.local.KeguanWxcardinfo;

import java.util.List;

public interface KeguanWxcardinfoService extends BaseService<KeguanWxcardinfo> {


    List<KeguanWxcardinfo> findList(String sellerId,Long shopId,String merchantid);
}

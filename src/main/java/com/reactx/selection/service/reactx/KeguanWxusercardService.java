package com.reactx.selection.service.reactx;

import com.reactx.selection.models.base.BaseService;
import com.reactx.selection.models.data.local.KeguanWxusercard;

import java.util.List;

public interface KeguanWxusercardService extends BaseService<KeguanWxusercard> {

    List<KeguanWxusercard> findBySellerIdAndCardId(String sellerId, String cardId);
}

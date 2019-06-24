package com.reactx.selection.service.reactx.impl;

import com.reactx.selection.mappers.KeguanWxusercardMapper;
import com.reactx.selection.models.base.BaseServiceImpl;
import com.reactx.selection.models.data.local.KeguanWxusercard;
import com.reactx.selection.service.reactx.KeguanWxusercardService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KeguanWxusercardServiceImpl extends BaseServiceImpl<KeguanWxusercardMapper, KeguanWxusercard>
		implements KeguanWxusercardService {

	@Override
	public List<KeguanWxusercard> findBySellerIdAndCardId(String sellerId, String cardId) {
		return baseMapper.findBySellerIdAndCardId("app_"+sellerId,cardId);
	}
}

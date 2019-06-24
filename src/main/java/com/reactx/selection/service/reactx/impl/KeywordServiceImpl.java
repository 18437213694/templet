package com.reactx.selection.service.reactx.impl;

import com.reactx.selection.configs.redis.RedisRepository;
import com.reactx.selection.models.base.SysStatic;
import com.reactx.selection.service.reactx.KeywordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class KeywordServiceImpl implements KeywordService {

	@Autowired
	private RedisRepository redisRepository;

	@Override
	@Async
	public void augment(String keyword) {
		Object object = redisRepository.getHashValues(SysStatic.QUERY_KEYWORD_CACHE_KEY, keyword);
		if (object == null) {
			redisRepository.putHashValue(SysStatic.QUERY_KEYWORD_CACHE_KEY, keyword, "1");
			return;
		}
		long num = Long.parseLong(object.toString());
		redisRepository.putHashValue(SysStatic.QUERY_KEYWORD_CACHE_KEY, keyword, (num + 1) + "");
	}


}

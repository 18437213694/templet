package com.reactx.selection.models.data.pinduoduo.util;

import com.reactx.selection.models.base.util.MD5Util;
import com.reactx.selection.models.data.pinduoduo.base.BasePddRequest;
import com.reactx.selection.models.data.pinduoduo.base.Param;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.Map;
import java.util.TreeSet;

public class PopClientUtil {

	private static TreeSet<Param> params = new TreeSet<>();

	public synchronized static String getSign(BasePddRequest request, String secret) throws Exception {
		params.clear();
		Map<String, String> map = BeanUtils.describe(request);
		for (String key : map.keySet()) {
			if (!key.equals("class")&&!key.equals("sign")) {
				String value = map.get(key);
				if (StringUtils.isNotBlank(value))
					params.add(new Param(key, value));
			}
		}
		StringBuilder builder = new StringBuilder(secret);
		while (params.size() > 0) {
			Param param = params.pollFirst();
			builder.append(param.getKey() + param.getValue());
		}
		builder.append(secret);
		return MD5Util.getMd5(builder.toString()).toUpperCase();
	}

}

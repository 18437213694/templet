package com.reactx.selection.models.base.util;

import java.util.regex.Pattern;

/**
 * 电话号码验证类
 * 
 */
public final class PhoneUtil {

	/** 手机号码正则 */
	public static final Pattern pattern = Pattern.compile("^1[3-9]\\d{9}$");

	private PhoneUtil() {
	}

	/**
	 * 验证手机号
	 * 
	 * @param mobile
	 * @return
	 */
	public static boolean checkMobile(String mobile) {
		return pattern.matcher(mobile).matches();
	}

}
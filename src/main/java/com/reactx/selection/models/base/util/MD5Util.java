package com.reactx.selection.models.base.util;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * md5加密工具类
 * @author Administrator
 *
 */
public class MD5Util {
	public static String getMd5(String inStr){
		return DigestUtils.md5Hex(inStr);
	}
	
	public static void main(String[] args) {
		System.out.println(getMd5("123456"));
	}
}

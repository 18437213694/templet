package com.reactx.selection.models.base.util;

import javax.servlet.http.HttpServletRequest;

/**
 *
 * @Author Mr.han
 * @Date 2017年8月20日 下午4:10:09
 * @Version 1.0
 *
 */
public class HeaderUtil {

	/**
	 * 判断当前请求是否为Ajax 请求
	 * 
	 * @param request
	 * @return
	 */
	public static boolean isAjax(HttpServletRequest request) {
		String requestedHeader = request.getHeader("x-requested-with");
		return requestedHeader != null && requestedHeader.equalsIgnoreCase("XMLHttpRequest");
	}

	/**
	 * 判断请求是否接受json数据
	 * 
	 * @param request
	 * @return
	 */
	public static boolean isAcceptJson(HttpServletRequest request) {
		String accept = request.getHeader("Accept");
		return accept != null && (accept.startsWith("application/json"));
	}

	public static boolean isContentJson(HttpServletRequest request) {
		String type = request.getHeader("Content-Type");
		return type != null && (type.startsWith("application/json"));
	}

}

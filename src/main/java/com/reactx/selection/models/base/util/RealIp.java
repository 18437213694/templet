package com.reactx.selection.models.base.util;

import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;

public class RealIp {
	public static String getIp(HttpServletRequest request) {
		String ip = request.getHeader("X-Forwarded-For");
		if (StringUtils.isNotEmpty(ip) && !"unKnown".equalsIgnoreCase(ip)) {
			// 多次反向代理后会有多个ip值，第一个ip才是真实ip
			int index = ip.indexOf(",");
			if (index != -1) {
				return ip.substring(0, index);
			} else {
				return ip;
			}
		}
		ip = request.getHeader("X-Real-IP");

		if (StringUtils.isNotEmpty(ip) && !"unKnown".equalsIgnoreCase(ip)) {
			return ip;
		}
		ip = request.getRemoteAddr();
		if (ip.equals("0:0:0:0:0:0:0:1") || ip == null) {
			return "127.0.0.1";
		}
		return ip;
	}

	public static String getRequestUrl(HttpServletRequest request) {
		String path = request.getContextPath();
		String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path
				+ "/";

		return basePath;
	}

	public static String getHost(HttpServletRequest request) {
		return request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort();
	}

	public static String getRealPath(HttpServletRequest request) {

		// return request.getRealPath("").replace("\busgo", "");
		return "E:\\apache-tomcat-7.0.37\\webapps";
	}
}

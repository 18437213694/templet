package com.reactx.selection.models.base.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Calendar;
import java.util.Date;

public class StuSessionDataUtil {

	public static String getValue(HttpServletRequest request, String key) {
		 
		return (String) request.getSession().getAttribute(key);
	}

	public static void setStuDataSession(HttpServletRequest request, String key, String value) {
		HttpSession session = request.getSession();
		session.setAttribute(key, value);
		session.setMaxInactiveInterval(getSecond());
	}

	private static int getSecond() {
		Calendar calendar1 = Calendar.getInstance();
		calendar1.set(calendar1.get(Calendar.YEAR), calendar1.get(Calendar.MONTH), calendar1.get(Calendar.DAY_OF_MONTH),
				0, 0, 0);
		Date beginOfDate = calendar1.getTime();
		System.out.println(DateUtil.getDateTime(beginOfDate));
		Calendar calendar2 = Calendar.getInstance();
		calendar1.set(calendar2.get(Calendar.YEAR), calendar2.get(Calendar.MONTH), calendar2.get(Calendar.DAY_OF_MONTH),
				23, 59, 59);
		return (int) (calendar1.getTimeInMillis() - System.currentTimeMillis()) / 1000;
	}
}

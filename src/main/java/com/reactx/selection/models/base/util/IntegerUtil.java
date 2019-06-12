package com.reactx.selection.models.base.util;

public class IntegerUtil {
	public static boolean isBlank(Integer i) {
		return !isNotBlank(i);
	}

	public static boolean isNotBlank(Integer i) {
		if (i == null) {
			return false;
		}
		return true;
	}
}

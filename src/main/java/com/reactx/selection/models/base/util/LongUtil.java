package com.reactx.selection.models.base.util;

public class LongUtil {

	public static boolean isBlank(Long L) {
		return !isNotBlank(L);
	}

	public static boolean isNotBlank(Long L) {
		if (L == null || L == 0) {
			return false;
		}
		return true;
	}

}


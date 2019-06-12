package com.reactx.selection.models.base.util;

import java.util.UUID;

public class MakeUUID {
	public static void main(String[] args) {
		String ss = getUUID();
			System.out.println(ss);
	}

	public static String getUUID() {
		String s = UUID.randomUUID().toString();
		// 去掉"-"符号
		return s.replace("-", "");
	}
	public static String[] getUUID(int number) {
		if (number < 1) {
			return null;
		}
		String[] ss = new String[number];
		for (int i = 0; i < number; i++) {
			ss[i] = getUUID();
		}
		return ss;
	}

}
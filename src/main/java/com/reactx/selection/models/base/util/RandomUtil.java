package com.reactx.selection.models.base.util;

import java.util.Random;

/**
 * java生成随机数（有重复）
 * 
 * @author 虚无缥缈
 *
 */
public class RandomUtil {

	public static String getRandomChar() {
		return getRandomChar(10);
	}

	public static String getRandomChar(int length) { // 生成随机字符串
		char[] chr = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I',
				'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd',
				'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y',
				'z' };

		Random random = new Random();
		StringBuffer buffer = new StringBuffer();
		for (int i = 0; i < length; i++) {
			buffer.append(chr[random.nextInt(62)]);
		}
		return buffer.toString();
	}

	public static void main(String[] args) {
		System.out.println(getRandomChar(50));
	}
}
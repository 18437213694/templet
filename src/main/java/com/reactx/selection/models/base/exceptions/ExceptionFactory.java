package com.reactx.selection.models.base.exceptions;

/**
 * 系统异常工具类
 * 
 *
 */
public class ExceptionFactory {

	/**
	 * 基础自定义异常
	 * 
	 * @param message
	 *            错误消息
	 * @param args
	 *            错误参数
	 * @see 错误参数由 String.format() 处理
	 * @return
	 * @throws BaseException
	 *             基础异常类
	 */
	public static BaseException build(String message, Object... args) throws BaseException {
		if (args != null && args.length > 0) {
			message = String.format(message, args);
		}
		throw new BaseException(message);
	}

	/**
	 * 基础自定义异常
	 * 
	 * @param message
	 *            错误消息
	 * @param args
	 *            错误参数
	 * @see 错误参数由 String.format() 处理
	 * @return 基础异常类
	 */
	public static BaseException build(String message) throws BaseException {
		throw new BaseException(message);
	}

}

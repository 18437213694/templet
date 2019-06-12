package com.reactx.selection.models.base.exceptions;

/**
 * 基础异常
 * 
 * @author Mr.han
 *
 */
public class BaseException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private String message;

	public BaseException(String message, Throwable throwable) {
		super(message, throwable);
		this.setMessage(message);
	}

	public BaseException(String message) {
		super(message);
		this.setMessage(message);
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}

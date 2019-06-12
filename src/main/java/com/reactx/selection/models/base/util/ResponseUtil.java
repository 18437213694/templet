package com.reactx.selection.models.base.util;


import com.reactx.selection.models.base.Result;

public final class ResponseUtil {

	public static final String FAULT_CODE = "500";
	public static final String PARAM_ERROR_CODE = "501";
	public static final String SUCCESS_CODE = "200";

	public static final String SUCCESS_MSG = "OK";
	public static final String PARAM_ERROR_MSG = "请求参数错误";
	public static final String FAULT_MSG = "服务繁忙，请稍后再试";
	public static final String UNKNOWN_MSG = "服务繁忙，请稍后再试";

	public static <T> Result<T> getFaultResult() {
		return new Result<T>(FAULT_CODE, FAULT_MSG);
	}

	public static <T> Result<T> getSuccessResult(T obj) {
		return new Result<T>(SUCCESS_CODE, SUCCESS_MSG, obj);
	}

	public static <T> Result<T> getUnknownResult() {
		return new Result<T>(FAULT_CODE, UNKNOWN_MSG);
	}

	public static <T> Result<T> getParamErrorResult(String msg) {
		return new Result<T>(PARAM_ERROR_CODE, msg, null);
	}

}

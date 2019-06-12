package com.reactx.selection.models.base;

import com.reactx.selection.models.base.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 控制器基类
 */
public abstract class BaseController {
	protected static final Logger logger = LoggerFactory.getLogger(BaseController.class);
	
	/** 返回成功数据 */
	protected <T> Result<T> response(T data) {
		return ResponseUtil.getSuccessResult(data);
	}

	/**
	 * 返回操作成功
	 * 
	 * @return
	 */
	protected Result<Object> response() {
		return ResponseUtil.getSuccessResult(null);
	}

	/**
	 * 返回值自定义错误消息
	 * 
	 * @return
	 */
	protected Result<Object> responseMsg(String errorCode, String args) {
		return new Result<Object>(errorCode, args);
	}

	/**
	 * 返回错误消息
	 * 
	 * @return
	 */
	protected Result<Object> responseMsg(String msg) {
		return new Result<Object>(ResponseUtil.PARAM_ERROR_CODE, msg);
	}
	

}

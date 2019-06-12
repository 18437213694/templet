package com.reactx.selection.models.base.exceptions;

import com.reactx.selection.models.base.Result;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * 异常处理器
 * 
 * @author eleven.
 *
 */
@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(BaseException.class)
	@ResponseBody
	public Result<String> illegalPropExceptionHandler(HttpServletRequest request, BaseException exception)
			throws Exception {
		return new Result<String>("501", exception.getMessage());
	}

	/*@ExceptionHandler(Exception.class)
	@ResponseBody
	public Result<String> exceptionHandler(HttpServletRequest request, Exception exception) throws Exception {
		return ResponseUtil.getFaultResult();
	}*/
}

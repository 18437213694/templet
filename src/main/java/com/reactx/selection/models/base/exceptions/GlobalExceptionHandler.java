package com.reactx.selection.models.base.exceptions;

import com.reactx.selection.models.enums.ErrorEnum;
import com.reactx.selection.restful.Result;
import com.reactx.selection.restful.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.SQLIntegrityConstraintViolationException;


@ControllerAdvice
public class GlobalExceptionHandler {
    private final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler
    @ResponseBody
    public Result nullPointHandler(NullPointerException e) {
        e.printStackTrace();
        logger.warn(e.getMessage());
        return ResultUtil.error(ErrorEnum.E_100000);
    }

    @ExceptionHandler(value = HttpRequestMethodNotSupportedException.class)
    @ResponseBody
    public Result methodNotSupportHandler(HttpRequestMethodNotSupportedException e) {
        e.printStackTrace();
        return ResultUtil.error(ErrorEnum.E_100001);
    }

    @ExceptionHandler(value = MissingServletRequestParameterException.class)
    @ResponseBody
    public Result missingServletRequestParameterHandler(MissingServletRequestParameterException e) {
        e.printStackTrace();
        return ResultUtil.error(ErrorEnum.E_100002);
    }

    @ExceptionHandler(value = SQLIntegrityConstraintViolationException.class)
    @ResponseBody
    public Result sqlIntegrityConstraintViolationHandler(SQLIntegrityConstraintViolationException e) {
        e.printStackTrace();
        return ResultUtil.error(ErrorEnum.E_100003);
    }
}

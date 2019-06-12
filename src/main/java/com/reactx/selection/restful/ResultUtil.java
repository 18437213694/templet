package com.reactx.selection.restful;

import com.reactx.selection.models.enums.ErrorEnum;
import com.reactx.selection.models.base.exceptions.ResultException;

public class ResultUtil {
    public static Result success(Object object) {
        Result result = new Result();

        result.setData(object);
        result.setErrmsg("");
        result.setErrno(0);

        return result;
    }

    public static Result success() {
        return success("Request Success");
    }

    public static Result error(ErrorEnum errorEnum) {
        Result result = new Result();

        result.setErrno(errorEnum.getErrorCode());
        result.setErrmsg(errorEnum.getErrorMsg());

        return result;
    }

    public static Result error(ResultException e) {
        return error(e.getErrorEnum());
    }
}

package com.reactx.selection.models.base.exceptions;

import com.reactx.selection.models.enums.ErrorEnum;

public class ResultException extends Exception {
    private ErrorEnum errorEnum;

    public ResultException(ErrorEnum errorEnum) {
        this.errorEnum = errorEnum;
    }

    public ErrorEnum getErrorEnum() {
        return errorEnum;
    }

    public void setErrorEnum(ErrorEnum errorEnum) {
        this.errorEnum = errorEnum;
    }
}

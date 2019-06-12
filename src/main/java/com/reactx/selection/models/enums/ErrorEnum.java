package com.reactx.selection.models.enums;

public enum ErrorEnum {
    E_100000(100000, "服务器错误！"),//NullPointException
    E_100001(100001, "请求方式错误！"),
    E_100002(100002, "请求参数缺失！"),
    E_100003(100003, "数据库错误！");

    private Integer errorCode;
    private String errorMsg;

    ErrorEnum() {

    }

    ErrorEnum(Integer errorCode, String errorMsg) {
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public Integer getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }
}

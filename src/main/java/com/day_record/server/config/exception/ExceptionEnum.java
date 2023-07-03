package com.day_record.server.config.exception;

/**
 * @author JereChen
 */
public enum ExceptionEnum implements BaseErrorInfo {
    /**
     * 错误定义
     */
    SUCCESS(200, "成功!"),
    BODY_NOT_MATCH(4000, "请求的数据格式不符!"),
    SIGNATURE_NOT_MATCH(4001, "请求的数字签名不匹配!"),
    NOT_FOUND(4004, "未找到该资源!"),
    INTERNAL_SERVER_ERROR(5000, "服务器内部错误!"),
    SERVER_BUSY(5003, "服务器正忙，请稍后再试!");

    /**
     * 错误码
     */
    private final Integer resultCode;

    /**
     * 错误描述
     */
    private final String resultMsg;

    ExceptionEnum(Integer resultCode, String resultMsg) {
        this.resultCode = resultCode;
        this.resultMsg = resultMsg;
    }

    @Override
    public Integer getResultErrorCode() {
        return resultCode;
    }

    @Override
    public String getResultErrorMsg() {
        return resultMsg;
    }

}

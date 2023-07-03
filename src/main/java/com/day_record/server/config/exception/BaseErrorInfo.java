package com.day_record.server.config.exception;

/**
 * @author JereChen
 */
public interface BaseErrorInfo {
    /**
     * 错误码
     *
     * @return
     */
    Integer getResultErrorCode();

    /**
     * 错误描述
     *
     * @return
     */
    String getResultErrorMsg();

}

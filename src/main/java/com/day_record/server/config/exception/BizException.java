package com.day_record.server.config.exception;

/**
 * 自定义异常类
 *
 * @author JereChen
 */
public class BizException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    /**
     * 错误码
     */
    protected Integer errorCode;
    /**
     * 错误信息
     */
    protected String errorMsg;

    public BizException() {
        super();
    }

    public BizException(BaseErrorInfo errorInfoInterface) {
        super(errorInfoInterface.getResultErrorMsg());
        this.errorCode = errorInfoInterface.getResultErrorCode();
        this.errorMsg = errorInfoInterface.getResultErrorMsg();
    }

    public BizException(BaseErrorInfo errorInfoInterface, Throwable cause) {
        super(errorInfoInterface.getResultErrorMsg(), cause);
        this.errorCode = errorInfoInterface.getResultErrorCode();
        this.errorMsg = errorInfoInterface.getResultErrorMsg();
    }

    public BizException(String errorMsg) {
        super(errorMsg);
        this.errorCode = 500;
        this.errorMsg = errorMsg;
    }

    public BizException(Integer errorCode, String errorMsg) {
        super(errorMsg);
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public BizException(Integer errorCode, String errorMsg, Throwable cause) {
        super(errorMsg, cause);
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

    @Override
    public Throwable fillInStackTrace() {
        return this;
    }
}


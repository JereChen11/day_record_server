package com.day_record.server.bean;

import com.day_record.server.config.exception.BaseErrorInfo;

/**
 * @author JereChen
 */
public class BaseBean<T> {
    Integer code;
    T data;
    Long dts;
    String msg;

    public BaseBean() {

    }

    public BaseBean(T data) {
        this.code = 200;
        this.data = data;
        this.dts = System.currentTimeMillis();
        this.msg = "success";
    }

    public BaseBean(int code, T data, String msg) {
        this.code = code;
        this.data = data;
        this.dts = System.currentTimeMillis();
        this.msg = msg;
    }

    public BaseBean(BaseErrorInfo baseErrorInfo) {
        this.code = baseErrorInfo.getResultErrorCode();
        this.msg = baseErrorInfo.getResultErrorMsg();
    }

    public static BaseBean success(Object data) {
        BaseBean bb = new BaseBean();
        bb.setCode(200);
        bb.setData(data);
        bb.setDts(System.currentTimeMillis());
        bb.setMsg("success");
        return bb;
    }

    public static BaseBean error(BaseErrorInfo baseErrorInfo) {
        BaseBean bb = new BaseBean();
        bb.setCode(baseErrorInfo.getResultErrorCode());
        bb.setMsg(baseErrorInfo.getResultErrorMsg());
        bb.setData(null);
        bb.setDts(System.currentTimeMillis());
        return bb;
    }

    public static BaseBean error(Integer code, String message) {
        BaseBean bb = new BaseBean();
        bb.setCode(code);
        bb.setMsg(message);
        bb.setData(null);
        bb.setDts(System.currentTimeMillis());
        return bb;
    }

    public static BaseBean error(String message) {
        BaseBean bb = new BaseBean();
        bb.setCode(-1);
        bb.setMsg(message);
        bb.setData(null);
        bb.setDts(System.currentTimeMillis());
        return bb;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Long getDts() {
        return dts;
    }

    public void setDts(Long dts) {
        this.dts = dts;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

}

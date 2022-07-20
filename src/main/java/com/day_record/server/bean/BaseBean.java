package com.day_record.server.bean;

public class BaseBean<T> {
    int code;
    T data;
    Long dts;
    String msg;

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

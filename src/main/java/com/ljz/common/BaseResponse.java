package com.ljz.common;

public class BaseResponse {

	private String code;
	private String msg;
	private Object object;

	public BaseResponse(String code, String msg) {
	    this.code = code;
	    this.msg = msg;
	}

    public BaseResponse(String code, String msg, Object object) {
        this.code = code;
        this.msg = msg;
        this.object = object;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }
}

package com.xiaolc.util;


public class JSONResponse {

    private Integer code;
    private Object data;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public JSONResponse() {
    }

    public JSONResponse(Integer code, Object data) {
        this.code = code;
        this.data = data;
    }
}

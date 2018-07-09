package com.example.dto;

import java.io.Serializable;

public class MVCResult<T> implements Serializable {
    public int code = 0;
    public String error = "";
    public T data;

    public static MVCResult create(Object data) {
        MVCResult mvcResult = new MVCResult();
        mvcResult.data = data;
        return mvcResult;
    }

    public static MVCResult create(Object data, String error) {
        MVCResult mvcResult = new MVCResult();
        mvcResult.data = data;
        mvcResult.error = error;
        return mvcResult;
    }

    @Override
    public String toString() {
        return "MVCResult {" + "code=" + code + ", error='" + error + '\'' + ", data=" + data + '}';
    }
}


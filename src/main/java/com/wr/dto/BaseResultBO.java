package com.wr.dto;

import java.io.Serializable;

/**
 * Created by 文歌 on 2017/9/3.
 */
public class BaseResultBO<T> implements Serializable {
    private static final long serialVersionUID = 4678848500765255889L;
    private String code;
    private String msg;
    private T object;

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

    public T getObject() {
        return object;
    }

    public void setObject(T object) {
        this.object = object;
    }

    @Override
    public String toString() {
        return "BaseResultBO{" +
                "code='" + code + '\'' +
                ", msg='" + msg + '\'' +
                ", object=" + object +
                '}';
    }
}

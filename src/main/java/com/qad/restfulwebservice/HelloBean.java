package com.qad.restfulwebservice;

public class HelloBean {
    private final String msg;

    public HelloBean(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    @Override
    public String toString() {
        return "HelloBean{" +
                "msg='" + msg + '\'' +
                '}';
    }
}

package com.bigdata.hbr.exception;

/**
 * Created by Percy on 2016/8/1.
 */
public class GenericException extends Exception {

    public GenericException() {
        super("未知错误");
    }

    public GenericException(String s) {
        super(s);
    }

    public GenericException(String s, Throwable throwable) {
        super(s, throwable);
    }
}

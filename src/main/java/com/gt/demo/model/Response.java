package com.gt.demo.model;

public class Response<T> {
    public T data;
    public int statusCode;

    public Response(T data, int statusCode) {
        this.data = data;
        this.statusCode = statusCode;
    }
}

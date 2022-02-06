package com.gt.demo.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class Response<T> {
    public T data;
    public int statusCode;
}

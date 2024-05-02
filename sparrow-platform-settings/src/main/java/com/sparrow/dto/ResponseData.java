package com.sparrow.dto;

import lombok.Data;

@Data
public class ResponseData<T> {
    private int code;
    private String message;
    private T data;
  

    public ResponseData(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    // Getters and setters
}

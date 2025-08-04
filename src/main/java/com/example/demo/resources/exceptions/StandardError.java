package com.example.demo.resources.exceptions;

import java.io.Serializable;

public class StandardError implements Serializable {

    private Long timestap;
    private Integer Status;
    private String error,message,path;

    public StandardError() {
    }

    public StandardError(Long timestap, Integer status, String error, String message, String path) {
        this.timestap = timestap;
        Status = status;
        this.error = error;
        this.message = message;
        this.path = path;
    }

    public Long getTimestap() {
        return timestap;
    }

    public void setTimestap(Long timestap) {
        this.timestap = timestap;
    }

    public Integer getStatus() {
        return Status;
    }

    public void setStatus(Integer status) {
        Status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}

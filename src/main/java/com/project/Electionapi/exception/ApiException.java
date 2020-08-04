package com.project.Electionapi.exception;

public class ApiException extends RuntimeException{

    private String detail;
    private Integer status;

    public ApiException(String message, String detail,Integer status) {
        super(message);
        this.detail = detail;
        this.status = status;
    }


    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}

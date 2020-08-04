package com.project.Electionapi.exception;

public class ResponseException {

    private String message;
    private String detail;
    private Long timesTamp;
    private String path;

    public ResponseException(String message, String detail, Long timesTamp, String path) {
        this.message = message;
        this.detail = detail;
        this.timesTamp = timesTamp;
        this.path = path;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public Long getTimesTamp() {
        return timesTamp;
    }

    public void setTimesTamp(Long timesTamp) {
        this.timesTamp = timesTamp;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}

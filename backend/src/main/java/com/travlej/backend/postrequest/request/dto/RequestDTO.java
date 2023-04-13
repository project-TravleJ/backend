package com.travlej.backend.postrequest.request.dto;

import java.util.Date;

public class RequestDTO {

    private int requestId;
    private String title;
    private java.util.Date date;
    private String writer;
    private String context;
    private String requestManagement;

    public RequestDTO() {}

    public RequestDTO(int requestId, String title, Date date, String writer, String context, String requestManagement) {
        this.requestId = requestId;
        this.title = title;
        this.date = date;
        this.writer = writer;
        this.context = context;
        this.requestManagement = requestManagement;
    }

    public int getRequestId() {
        return requestId;
    }

    public void setRequestId(int requestId) {
        this.requestId = requestId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public String getRequestManagement() {
        return requestManagement;
    }

    public void setRequestManagement(String requestManagement) {
        this.requestManagement = requestManagement;
    }

    @Override
    public String toString() {
        return "RequestDTO{" +
                "requestId=" + requestId +
                ", title='" + title + '\'' +
                ", date=" + date +
                ", writer='" + writer + '\'' +
                ", context='" + context + '\'' +
                ", requestManagement='" + requestManagement + '\'' +
                '}';
    }
}

package com.travlej.backend.postrequest.request.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity(name = "Request")
@Table(name = "REQUESTS")
public class Request {

    @Id
    @Column(name = "REQUEST_ID")
    private int requestId;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "DATE")
    private java.util.Date date;

    @Column(name = "WRITER")
    private String writer;

    @Column(name = "CONTEXT")
    private String context;

    @Column(name = "REQUEST_MANAGEMENT")
    private String requestManagement;

    public Request() {}

    public Request(int requestId, String title, Date date, String writer, String context, String requestManagement) {
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
        return "Request{" +
                "requestId=" + requestId +
                ", title='" + title + '\'' +
                ", date=" + date +
                ", writer='" + writer + '\'' +
                ", context='" + context + '\'' +
                ", requestManagement='" + requestManagement + '\'' +
                '}';
    }
}

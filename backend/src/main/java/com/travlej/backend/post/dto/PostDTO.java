package com.travlej.backend.post.dto;


import org.springframework.data.annotation.Id;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Column;
import java.util.Date;

public class PostDTO {

    private int postId;
    private String postTitle;
    private java.util.Date postDate;
    private String writer;
    private java.util.Date postStart;
    private java.util.Date postEnd;
    private String course;
    private String context;
    private int likes;

    public PostDTO() {}

    public PostDTO(int postId, String postTitle, Date postDate, String writer, Date start, Date end, String course, String context, int likes) {
        this.postId = postId;
        this.postTitle = postTitle;
        this.postDate = postDate;
        this.writer = writer;
        this.postStart = start;
        this.postEnd = end;
        this.course = course;
        this.context = context;
        this.likes = likes;
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public String getPostTitle() {
        return postTitle;
    }

    public void setPostTitle(String postTitle) {
        this.postTitle = postTitle;
    }

    public Date getPostDate() {
        return postDate;
    }

    public void setPostDate(Date postDate) {
        this.postDate = postDate;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public Date getPostStart() {
        return postStart;
    }

    public void setPostStart(Date start) {
        this.postStart = start;
    }

    public Date getPostEnd() {
        return postEnd;
    }

    public void setPostEnd(Date end) {
        this.postEnd = end;
    }

    public String getCourse() { return course; }

    public void setCourse(String course) { this.course = course; }

    public String getContext() { return context; }

    public void setContext( String context ) { this.context = context; }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    @Override
    public String toString() {
        return "PostDTO{" +
                "postId='" + postId + '\'' +
                ", postTitle='" + postTitle + '\'' +
                ", postDate=" + postDate +
                ", writer='" + writer + '\'' +
                ", start=" + postStart +
                ", end=" + postEnd + '\'' +
                ", course=" + course + '\'' +
                ", context=" + context +
                ", likes=" + likes +
                '}';
    }
}

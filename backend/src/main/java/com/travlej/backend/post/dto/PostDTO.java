package com.travlej.backend.post.dto;


import com.travlej.backend.course.dto.CourseDTO;
import com.travlej.backend.course.entity.Course;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PostDTO {

    private int postId;
    private String postTitle;
    private java.util.Date postDate;
    private String writer;
    private java.util.Date postStart;
    private java.util.Date postEnd;
    private List<CourseDTO> courseList;
    private String context;
    private int likes;

    public PostDTO() {}

    public PostDTO(int postId, String postTitle, Date postDate, String writer, Date start, Date end, List<CourseDTO> courseList, String context, int likes) {
        this.postId = postId;
        this.postTitle = postTitle;
        this.postDate = postDate;
        this.writer = writer;
        this.postStart = start;
        this.postEnd = end;
        this.courseList = courseList;
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

    public List<CourseDTO> getCourseList() { return courseList; }

    public void setCourseList(List<CourseDTO> courseList) { this.courseList = courseList; }

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
                ", courseList=" + courseList.size() + '\'' +
                ", context=" + context +
                ", likes=" + likes +
                '}';
    }
}

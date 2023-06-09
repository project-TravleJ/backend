package com.travlej.backend.post.entity;

import com.travlej.backend.course.entity.Course;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity(name = "Post")
@Table(name="POST")
public class Post {

    @Id
    @Column(name = "POST_ID")
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
          // MySql은 Oracle과 달리 sequence를 사용하기 위한 조건이 까다롭다. 사전에 준비해야 하는 것들이 많아,
          // sequence를 별도로 선언하지 않고 JPA 내부의 프로퍼티?를 사용하여 시퀀스를 작동시킨다.
    )
    private int postId;

    @Column(name = "POST_TITLE")
    private String postTitle;

    @Column(name = "POST_DATE")
    @DateTimeFormat(pattern = "YYYY-MM-DD")
    private java.util.Date postDate;

    @Column(name="WRITER")
    private String writer;

    @Column(name = "POST_START")
    @DateTimeFormat(pattern = "YYYY-MM-DD")
    private java.util.Date postStart;

    @Column(name = "POST_END")
    @DateTimeFormat(pattern = "YYYY-MM-DD")
    private java.util.Date postEnd;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
    private List<Course> courseList = new ArrayList<>();

    @Column(name = "POST_CONTEXT")
    private String context;

    @Column(name = "LIKES")
    private int likes;

    public Post() {}

    public Post(int postId, String postTitle, Date postDate, String writer, Date postStart, Date postEnd, List<Course> courseList, String context, int likes) {
        this.postId = postId;
        this.postTitle = postTitle;
        this.postDate = postDate;
        this.writer = writer;
        this.postStart = postStart;
        this.postEnd = postEnd;
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

    public void setPostStart(Date postStart) {
        this.postStart = postStart;
    }

    public Date getPostEnd() {
        return postEnd;
    }

    public void setPostEnd(Date postEnd) {
        this.postEnd = postEnd;
    }

    public List<Course> getCourseList() { return courseList; }

    public void setCourseList(List<Course> courseList) { this.courseList = courseList; }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    @Override
    public String toString() {
        return "Post{" +
                "postId=" + postId +
                ", postTitle='" + postTitle + '\'' +
                ", postDate=" + postDate +
                ", writer=" + writer +
                ", postStart=" + postStart +
                ", postEnd=" + postEnd +
                ", context='" + context + '\'' +
                ", likes=" + likes +
                '}';
    }
}

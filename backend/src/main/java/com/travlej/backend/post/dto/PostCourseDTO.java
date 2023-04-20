package com.travlej.backend.post.dto;

import com.travlej.backend.attraction.dto.AttractionDTO;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class PostCourseDTO {

    private String postTitle;
    private String writer;
    private java.util.Date postDate;
    private java.util.Date postStart;
    private java.util.Date postEnd;
    private String postContext;
    private int likes;


    private List<AttractionDTO> attDTOList;
    private int[] courseIdxArr;
    private List<String> courseMemoList;

    public PostCourseDTO() {}

    public PostCourseDTO(String postTitle, String writer, Date postDate, Date postStart, Date postEnd, String postContext, int likes, List<AttractionDTO> attDTOList, int[] courseIdxArr, List<String> courseMemoList) {
        this.postTitle = postTitle;
        this.writer = writer;
        this.postDate = postDate;
        this.postStart = postStart;
        this.postEnd = postEnd;
        this.postContext = postContext;
        this.likes = likes;
        this.attDTOList = attDTOList;
        this.courseIdxArr = courseIdxArr;
        this.courseMemoList = courseMemoList;
    }

    public String getPostTitle() {
        return postTitle;
    }

    public void setPostTitle(String postTitle) {
        this.postTitle = postTitle;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public Date getPostDate() {
        return postDate;
    }

    public void setPostDate(Date postDate) {
        this.postDate = postDate;
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

    public String getPostContext() {
        return postContext;
    }

    public void setPostContext(String postContext) {
        this.postContext = postContext;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public List<AttractionDTO> getAttDTOList() {
        return attDTOList;
    }

    public void setAttDTOList(List<AttractionDTO> attDTOList) {
        this.attDTOList = attDTOList;
    }

    public int[] getCourseIdxArr() {
        return courseIdxArr;
    }

    public void setCourseIdxArr(int[] courseIdxArr) {
        this.courseIdxArr = courseIdxArr;
    }

    public List<String> getCourseMemoList() {
        return courseMemoList;
    }

    public void setCourseMemoList(List<String> courseMemoList) {
        this.courseMemoList = courseMemoList;
    }

    @Override
    public String toString() {
        return "PostCourseDTO{" +
                "postTitle='" + postTitle + '\'' +
                ", writer='" + writer + '\'' +
                ", postDate=" + postDate +
                ", postStart=" + postStart +
                ", postEnd=" + postEnd +
                ", postContext='" + postContext + '\'' +
                ", likes=" + likes +
                ", attDTOList=" + attDTOList +
                ", courseIdxArr=" + Arrays.toString(courseIdxArr) +
                ", courseMemoList=" + courseMemoList +
                '}';
    }
}

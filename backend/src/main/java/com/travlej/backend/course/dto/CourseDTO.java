package com.travlej.backend.course.dto;

import com.travlej.backend.attraction.dto.AttractionDTO;

public class CourseDTO {

    private int CourseId;
    private int idx;
    private int postId;
    private AttractionDTO attraction;
    private String courseMemo;

    public CourseDTO() {}

    public CourseDTO(int courseId, int idx, int postId, AttractionDTO attraction, String courseMemo) {
        CourseId = courseId;
        this.idx = idx;
        this.postId = postId;
        this.attraction = attraction;
        this.courseMemo = courseMemo;
    }

    public int getCourseId() {
        return CourseId;
    }

    public void setCourseId(int courseId) {
        CourseId = courseId;
    }

    public int getIdx() {
        return idx;
    }

    public void setIdx(int idx) {
        this.idx = idx;
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public AttractionDTO getAttraction() {
        return attraction;
    }

    public void setAttraction(AttractionDTO attraction) {
        this.attraction = attraction;
    }

    public String getCourseMemo(){
        return courseMemo;
    }

    public void setCourseMemo(String courseMemo) {
        this.courseMemo = courseMemo;
    }

    @Override
    public String toString() {
        return "CourseDTO{" +
                "CourseId=" + CourseId +
                ", idx=" + idx +
                ", postId=" + postId +
                ", attraction=" + attraction +
                ", courseMemo =" + courseMemo +
                '}';
    }
}

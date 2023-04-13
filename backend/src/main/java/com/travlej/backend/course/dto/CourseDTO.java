package com.travlej.backend.course.dto;

public class CourseDTO {

    private int CourseId;
    private int idx;
    private int postId;
    private int attractionId;

    public CourseDTO() {}

    public CourseDTO(int courseId, int idx, int postId, int attractionId) {
        CourseId = courseId;
        this.idx = idx;
        this.postId = postId;
        this.attractionId = attractionId;
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

    public int getAttractionId() {
        return attractionId;
    }

    public void setAttractionId(int attractionId) {
        this.attractionId = attractionId;
    }

    @Override
    public String toString() {
        return "CourseDTO{" +
                "CourseId=" + CourseId +
                ", idx=" + idx +
                ", postId=" + postId +
                ", attractionId=" + attractionId +
                '}';
    }
}

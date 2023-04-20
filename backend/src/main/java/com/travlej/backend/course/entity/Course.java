package com.travlej.backend.course.entity;

import com.travlej.backend.attraction.entity.Attraction;
import com.travlej.backend.post.entity.Post;

import javax.persistence.*;

@Entity(name = "Course")
@Table(name = "COURSE")
public class Course {

    @Id
    @Column(name = "COURSE_ID")
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private int CourseId;

    @Column(name = "IDX")
    private int idx;

    @ManyToOne
    @JoinColumn(name = "POST_ID")
    private Post post;

    @JoinColumn(name = "id")
    @ManyToOne
    private Attraction attraction;

    @Column(name  = "MEMO")
    private String courseMemo;

    public Course() {}

    public Course(int courseId, int idx, Post post, Attraction attraction, String courseMemo) {
        CourseId = courseId;
        this.idx = idx;
        this.post = post;
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

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public Attraction getAttraction() {
        return attraction;
    }

    public void setAttraction(Attraction attraction) {
        this.attraction = attraction;
    }

    public String getCourseMemo(){
        return courseMemo;
    }

    public void setCourseMemo(String courseMemo){
        this.courseMemo = courseMemo;
    }

    @Override
    public String toString() {
        return "Course{" +
                "CourseId=" + CourseId +
                ", idx=" + idx +
                ", post=" + post +
                ", attraction=" + attraction.getAttractionName() +
                ", memo=" + courseMemo +
                '}';
    }
}

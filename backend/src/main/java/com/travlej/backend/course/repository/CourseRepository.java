package com.travlej.backend.course.repository;

import com.travlej.backend.course.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Integer> {

    List<Course> findByPost_PostId(int postId);

    void deleteByPost_PostId(int postId);
}

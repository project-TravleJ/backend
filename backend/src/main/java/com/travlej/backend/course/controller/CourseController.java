package com.travlej.backend.course.controller;

import com.travlej.backend.attraction.dto.AttractionDTO;
import com.travlej.backend.common.ResponseDto;
import com.travlej.backend.course.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/v1/")
public class CourseController {

    private final CourseService courseService;

    @Autowired
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping("/posts/{postId}/courses")
    public ResponseEntity<ResponseDto> selectCourseByPostId(@PathVariable int postId){

        return ResponseEntity.ok().body(new ResponseDto(HttpStatus.OK, "게시글 코스 조회 완료", courseService.findCourseByPostId(postId)));
    }

    @PostMapping("/posts/{postId}/courses")
    public ResponseEntity<ResponseDto> registCourse(@PathVariable int postId, @RequestBody AttractionDTO attDTO){

        return ResponseEntity.ok().body(new ResponseDto(HttpStatus.OK, "코스 등록 성공", courseService.registNewCourse(postId, attDTO)));
    }

}

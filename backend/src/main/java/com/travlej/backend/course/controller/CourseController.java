package com.travlej.backend.course.controller;

import com.travlej.backend.attraction.dto.AttractionDTO;
import com.travlej.backend.common.ResponseDto;
import com.travlej.backend.course.dto.CourseDTO;
import com.travlej.backend.course.service.CourseService;
import com.travlej.backend.post.dto.PostCourseDTO;
import com.travlej.backend.post.dto.PostDTO;
import com.travlej.backend.post.entity.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public ResponseEntity<ResponseDto> registCourse(@PathVariable int postId, @RequestBody List<CourseDTO> courseDTOList){

        return ResponseEntity.ok().body(new ResponseDto(HttpStatus.OK, "코스 등록 성공", courseService.registNewCourseList(postId, courseDTOList)));
    }



}

package com.travlej.backend.post.controller;

import com.travlej.backend.common.ResponseDto;
import com.travlej.backend.post.dto.PostCourseDTO;
import com.travlej.backend.post.dto.PostDTO;
import com.travlej.backend.post.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/v1")
public class PostController {

    private final PostService postService;

    @Autowired
    public PostController(PostService postService){
        this.postService = postService;
    }


    @GetMapping("/posts")
    public ResponseEntity<ResponseDto> selectPostAll(){

        return ResponseEntity.ok().body(new ResponseDto(HttpStatus.OK, "전체 조회 성공", postService.findPostList()));
    }


    @GetMapping("/posts/{postId}")
    public ResponseEntity<ResponseDto> selectPostByPostId(@PathVariable int postId){

        return ResponseEntity.ok().body(new ResponseDto(HttpStatus.OK, "상세 조회 성공", postService.findPostByPostId(postId)));
    }

    @GetMapping("/posts/search/{title}")
    public ResponseEntity<ResponseDto> selectPostByTitle(@PathVariable String title){

        return ResponseEntity.ok().body(new ResponseDto(HttpStatus.OK, "제목 검색 조회",postService.findPostByPostTitle(title)));
    }


//
//    @GetMapping("/posts")
//    public void registPage() {}

    @PostMapping("/posts")
    public ResponseEntity<ResponseDto> registPost(@RequestBody PostDTO postDto){

        return ResponseEntity.ok().body(new ResponseDto(HttpStatus.CREATED, "게시글 등록 성공", postService.registNewPost(postDto)));
    }

    @PutMapping("/posts/{postId}")
    public ResponseEntity<ResponseDto> updatePost(@PathVariable int postId, @RequestBody PostDTO postDTO){

        return ResponseEntity.ok().body(new ResponseDto(HttpStatus.CREATED, "게시글 수정 성공", postService.updatePost(postId, postDTO)));
    }

    @DeleteMapping("/posts/{postId}")
    public ResponseEntity<ResponseDto> deletePost(@PathVariable int postId){

        return ResponseEntity.ok().body(new ResponseDto(HttpStatus.NO_CONTENT, "게시글 삭제 완료", postService.deletePost(postId)));
    }

    @PostMapping("/postswithcourse")
    public ResponseEntity<ResponseDto> regisePostWithCourse(@RequestBody PostDTO postDTO){

        return ResponseEntity.ok().body(new ResponseDto(HttpStatus.CREATED, "게시글 등록 완료", postService.registNewPostWithCourse(postDTO)));
    }

    @GetMapping("/posts/detailSearch")
    public ResponseEntity<ResponseDto> selectDetailSearch(@RequestBody PostDTO postDTO){

        return ResponseEntity.ok().body(new ResponseDto(HttpStatus.OK, "게시글 상세조회 완료", postService.selectDetailSearch(postDTO)));
    }
}

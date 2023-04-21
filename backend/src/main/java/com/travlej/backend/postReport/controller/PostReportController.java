package com.travlej.backend.postReport.controller;

import com.travlej.backend.common.ResponseDto;
import com.travlej.backend.post.entity.Post;
import com.travlej.backend.postReport.dto.PostReportDTO;
import com.travlej.backend.postReport.service.PostReportService;
import com.travlej.backend.repository.PostReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/v1/reports")
public class PostReportController {

   private final PostReportService postReportService;
   private PostReportRepository PostReportRep;

   @Autowired
   public PostReportController(PostReportService postReportService) { this.postReportService = postReportService; }

   @GetMapping(value = "/list")
   public  ResponseEntity<ResponseDto> findPostReportList() {

      return ResponseEntity.ok().body(new ResponseDto(HttpStatus.OK, "신고글 조회 성공", postReportService.findAllPostReport()));
   }
   @PostMapping("/reportPost")
   public ResponseEntity<ResponseDto> registPostReport(@RequestBody PostReportDTO postReportDTO){

      return ResponseEntity.ok().body(new ResponseDto(HttpStatus.CREATED, "신고글 등록 성공", postReportService.registNewPost(postReportDTO)));

   }

   @GetMapping("/{reportId}")
   public ResponseEntity<ResponseDto> findPostReportOne(@PathVariable int reportId) {

      return ResponseEntity.ok().body(new ResponseDto(HttpStatus.OK, "상세 조회 성공", postReportService.findOnePostReport(reportId)));
   }
   
   @PutMapping("/{reportId}")
   public ResponseEntity<ResponseDto> updatePostReport(@PathVariable int reportId, @RequestBody PostReportDTO postReportDTO){
      
      return ResponseEntity.ok().body(new ResponseDto(HttpStatus.CREATED, "게시글 수정 성공", postReportService.updatePostReport(reportId, postReportDTO)));
   }

   @DeleteMapping("{reportId}")
   public ResponseEntity<ResponseDto> deletePost(@PathVariable int reportId){

      return ResponseEntity.ok().body(new ResponseDto(HttpStatus.NO_CONTENT, "게시글 삭제 성공", postReportService.deletePostReport(reportId)));
   }

   @PostMapping("searchReport")
   public ResponseEntity<ResponseDto> searchReport(@RequestBody PostReportDTO postReportDTO){

      return ResponseEntity.ok().body(new ResponseDto(HttpStatus.CREATED, "상세 검색 성공", postReportService.detailSearchReport(postReportDTO)));
   }
      
}

package com.travlej.backend.postReport.controller;

import com.travlej.backend.common.ResponseDto;
import com.travlej.backend.postReport.dto.PostReportDTO;
import com.travlej.backend.postReport.service.PostReportService;
import com.travlej.backend.repository.PostReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
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

   @GetMapping(value = "/list", produces = "application/json; charset=UTF-8")
   @ResponseBody
   public List<PostReportDTO> findPostReportList() {

      return postReportService.findAllPostReport();
   }
   @PostMapping("/reportPost")
   public ResponseEntity<ResponseDto> registPostReport(@RequestBody PostReportDTO postReportDTO){

      return ResponseEntity.ok().body(new ResponseDto(HttpStatus.OK, "신고글 등록 성공", postReportService.registNewPost(postReportDTO)));

   }

   @GetMapping("/{reportId}")
   public ResponseEntity<ResponseDto> findPostReportOne(@PathVariable int reportId) {

      return ResponseEntity.ok().body(new ResponseDto(HttpStatus.OK, "상세 조회 성공", postReportService.findOnePostReport(reportId)));
   }
   
   @PutMapping("/{reportId}")
   public ResponseEntity<ResponseDto> updatePostReport(@PathVariable int reportId, @RequestBody PostReportDTO postReportDTO){
      
      return ResponseEntity.ok().body(new ResponseDto(HttpStatus.OK, "게시글 수정 성공", postReportService.updatePostReport(reportId, postReportDTO)));
   }

   @DeleteMapping("{reportId}")
   public ResponseEntity<ResponseDto> deletePost(@PathVariable int reportId){

      return ResponseEntity.ok().body(new ResponseDto(HttpStatus.OK, "게시글 삭제 성공", postReportService.deletePostReport(reportId)));
   }
      
}

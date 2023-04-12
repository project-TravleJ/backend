package com.travlej.backend.postReport.controller;

import com.travlej.backend.common.ResponseDto;
import com.travlej.backend.common.paging.Pagenation;
import com.travlej.backend.common.paging.PagingButtonInfo;
import com.travlej.backend.postReport.dto.PostReportDTO;
import com.travlej.backend.postReport.entity.PostReport;
import com.travlej.backend.postReport.service.PostReportService;
import com.travlej.backend.repository.PostReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

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


}

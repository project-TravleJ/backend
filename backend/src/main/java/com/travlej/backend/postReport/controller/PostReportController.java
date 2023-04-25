package com.travlej.backend.postReport.controller;

import com.travlej.backend.common.ResponseDto;
import com.travlej.backend.common.paging.Pagenation;
import com.travlej.backend.common.paging.PagingButtonInfo;
import com.travlej.backend.postReport.dto.PostReportDTO;
import com.travlej.backend.postReport.service.PostReportService;
import com.travlej.backend.postReport.repository.PostReportRepository;
import com.travlej.backend.postrequest.request.dto.RequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/api/v1/reports")
public class PostReportController {

   private final PostReportService postReportService;
   private PostReportRepository PostReportRep;

   @Autowired
   public PostReportController(PostReportService postReportService) { this.postReportService = postReportService; }

   @GetMapping(value = "/")
   public  ResponseEntity<ResponseDto> findPostReportList(ModelAndView mv, @PageableDefault Pageable pageable) {

      Page<PostReportDTO> reportList = postReportService.findAllPostReport(pageable);

      PagingButtonInfo paging = Pagenation.getPagingButtonInfo(reportList);

      Map<String, Object> responseMap = new HashMap<>();
      responseMap.put("reportList", reportList);
      responseMap.put("paging",paging);

      return ResponseEntity.ok().body(new ResponseDto(HttpStatus.OK, "전체 조회 성공", responseMap));
//      return ResponseEntity.ok().body(new ResponseDto(HttpStatus.OK, "신고글 조회 성공", postReportService.findAllPostReport()));
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
   public ResponseEntity<ResponseDto> searchReport(ModelAndView mv, @PageableDefault Pageable pageable, @RequestBody PostReportDTO postReportDTO){

      Page<PostReportDTO> SearchByReportMultiple = postReportService.SearchByReportMultiple(postReportDTO, pageable);

      PagingButtonInfo paging = Pagenation.getPagingButtonInfo(SearchByReportMultiple);

      Map<String, Object> responseMap = new HashMap<>();
      responseMap.put("SearchByReportMultiple", SearchByReportMultiple);
      responseMap.put("paging",paging);

      return ResponseEntity.ok().body(new ResponseDto(HttpStatus.OK, "검색 조회", responseMap));
//      return ResponseEntity.ok().body(new ResponseDto(HttpStatus.CREATED, "상세 검색 성공", postReportService.detailSearchReport(postReportDTO)));
   }
      
}

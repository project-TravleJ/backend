package com.travlej.backend.postrequest.request.controller;

import com.travlej.backend.common.paging.PagingButtonInfo;
import com.travlej.backend.common.paging.Pagenation;
import com.travlej.backend.common.ResponseDto;
import com.travlej.backend.postrequest.request.dto.RequestDTO;
import com.travlej.backend.postrequest.request.service.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import springfox.documentation.spring.web.readers.operation.ResponseMessagesReader;

import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/api/v1/requests")
public class RequestController {
    private final RequestService requestService;

    @Autowired
    public RequestController(RequestService requestService){
        this.requestService = requestService;
    }

    @GetMapping("/")
    public ResponseEntity<ResponseDto> selectRequestAll(ModelAndView mv, @PageableDefault Pageable pageable){

//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));

        Page<RequestDTO> requestList = requestService.findRequestList(pageable);

        PagingButtonInfo paging = Pagenation.getPagingButtonInfo(requestList);

        Map<String, Object> responseMap = new HashMap<>();
        responseMap.put("requestList", requestList);
        responseMap.put("paging",paging);

//        mv.addObject("requestList", requestList);
//        mv.addObject("paging", paging);
//        mv.setViewName("requests/page");

//        return ResponseEntity.ok().headers(headers).body(new ResponseDto(HttpStatus.OK,"전제 초회 성공",responseMap));
//      return ResponseEntity.ok().body(new ResponseDto(HttpStatus.OK, "전체 조회 성공", requestService.findRequestList(pageable)));
        return ResponseEntity.ok().body(new ResponseDto(HttpStatus.OK, "전체 조회 성공", responseMap));
    }


    @GetMapping("/{requestId}")
    public ResponseEntity<ResponseDto> selectRequestByRequestId(@PathVariable int requestId){

        return ResponseEntity.ok().body(new ResponseDto(HttpStatus.OK, "상세 조회 성공", requestService.findRequestByRequestId(requestId)));
    }

    @PostMapping("/request")
    public ResponseEntity<ResponseDto> registRequest(@RequestBody(required = false) RequestDTO requestDto) {
        System.out.println(1);
        System.out.println(requestDto);
        if (requestDto == null) {
            return ResponseEntity.badRequest().body(new ResponseDto(HttpStatus.BAD_REQUEST, "RequestDTO가 null입니다.", null));
        }
        System.out.println(2);
        return ResponseEntity.ok().body(new ResponseDto(HttpStatus.CREATED, "게시글 등록 성공", requestService.registNewRequest(requestDto)));
    }



    @PutMapping("/{requestId}")
    public ResponseEntity<ResponseDto> updateRequest(@PathVariable int requestId, @RequestBody RequestDTO requestDTO){

        return ResponseEntity.ok().body(new ResponseDto(HttpStatus.CREATED, "게시글 수정 성공", requestService.updateRequest(requestId, requestDTO)));
    }

    @DeleteMapping("/{requestId}")
    public ResponseEntity<ResponseDto> deleteRequest(@PathVariable int requestId){

        return ResponseEntity.ok().body(new ResponseDto(HttpStatus.NO_CONTENT, "게시글 삭제 완료", requestService.deleteRequest(requestId)));
    }

//    @PostMapping("/search")
//    public ResponseEntity<ResponseDto> SearchByMultiple(@RequestBody(required = false) RequestDTO requestDTO){
//
//        return ResponseEntity.ok().body(new ResponseDto(HttpStatus.CREATED, "작성자 검색 조회",requestService.SearchByMultiple(requestDTO)));
//    }

    @PostMapping("/search")
    public ResponseEntity<ResponseDto> SearchByMultiple(ModelAndView mv, @PageableDefault Pageable pageable, @RequestBody(required = false) RequestDTO requestDTO){

        Page<RequestDTO> searchByMultiple = requestService.SearchByMultiple(requestDTO, pageable);

        PagingButtonInfo paging = Pagenation.getPagingButtonInfo(searchByMultiple);

        Map<String, Object> responseMap = new HashMap<>();
        responseMap.put("searchByMultiple", searchByMultiple);
        responseMap.put("paging",paging);

        return ResponseEntity.ok().body(new ResponseDto(HttpStatus.OK, "작성자 검색 조회", responseMap));
//        return ResponseEntity.ok().body(new ResponseDto(HttpStatus.CREATED, "작성자 검색 조회",requestService.SearchByMultiple(requestDTO)));
    }


}

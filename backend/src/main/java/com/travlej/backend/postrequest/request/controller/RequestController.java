package com.travlej.backend.postrequest.request.controller;

import com.travlej.backend.common.ResponseDto;
import com.travlej.backend.postrequest.request.dto.RequestDTO;
import com.travlej.backend.postrequest.request.service.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/v1/requests")
public class RequestController {
    private final RequestService requestService;

    @Autowired
    public RequestController(RequestService requestService){
        this.requestService = requestService;
    }

    @GetMapping("/")
    public ResponseEntity<ResponseDto> selectRequestAll(){

        return ResponseEntity.ok().body(new ResponseDto(HttpStatus.OK, "전체 조회 성공", requestService.findRequestList()));
    }


    @GetMapping("/{requestId}")
    public ResponseEntity<ResponseDto> selectRequestByRequestId(@PathVariable int requestId){

        return ResponseEntity.ok().body(new ResponseDto(HttpStatus.OK, "상세 조회 성공", requestService.findRequestByRequestId(requestId)));
    }

    @PostMapping("/request")
    public ResponseEntity<ResponseDto> registRequest(@RequestBody RequestDTO requestDto){

        return ResponseEntity.ok().body(new ResponseDto(HttpStatus.OK, "게시글 등록 성공", requestService.registNewRequest(requestDto)));
    }

    @PutMapping("/{requestId}")
    public ResponseEntity<ResponseDto> updateRequest(@PathVariable int requestId, @RequestBody RequestDTO requestDTO){

        return ResponseEntity.ok().body(new ResponseDto(HttpStatus.OK, "게시글 수정 성공", requestService.updateRequest(requestId, requestDTO)));
    }

    @DeleteMapping("/{requestId}")
    public ResponseEntity<ResponseDto> deleteRequest(@PathVariable int requestId){

        return ResponseEntity.ok().body(new ResponseDto(HttpStatus.OK, "게시글 삭제 완료", requestService.deleteRequest(requestId)));
    }

}

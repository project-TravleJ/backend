//package com.travlej.backend.member.controller;
//
//import com.travlej.backend.common.ResponseDto;
//import com.travlej.backend.member.dto.MemberDTO;
//import com.travlej.backend.member.dto.RequestDTO;
//import com.travlej.backend.member.repository.MemberRepository;
//import com.travlej.backend.member.service.AuthService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequiredArgsConstructor
//public class AuthController {
//
//    private final MemberRepository memberRepository;
//    private final AuthService memberService;
//
//    @PostMapping(value = "/login")
//    public ResponseEntity<ResponseDto> signin(@RequestBody RequestDTO request) {
//
//        return ResponseEntity.ok().body(new ResponseDto(HttpStatus.OK, "로그인 성공!", memberService.login(request)));
//    }
//
//    @PostMapping(value = "/register")
//    public ResponseEntity<ResponseDto> signup(@RequestBody RequestDTO request) throws Exception {
//
//        return ResponseEntity.ok().body(new ResponseDto(HttpStatus.OK, "회원가입 성공!", memberService.register(request)));
//    }
//
//}

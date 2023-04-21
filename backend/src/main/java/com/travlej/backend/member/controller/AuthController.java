package com.travlej.backend.member.controller;

import com.travlej.backend.common.ResponseDto;
import com.travlej.backend.member.dto.RequestDTO;
import com.travlej.backend.member.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService memberService;

    @PostMapping(value = "/login")
    public ResponseEntity<ResponseDto> signin(@RequestBody RequestDTO request) {

        return ResponseEntity.ok().body(new ResponseDto(HttpStatus.CREATED, "로그인 성공!", memberService.login(request)));
    }

    @PostMapping(value = "/register")
    public ResponseEntity<ResponseDto> signup(@RequestBody RequestDTO request) throws Exception {

        return ResponseEntity.ok().body(new ResponseDto(HttpStatus.CREATED, "회원가입 성공!", memberService.register(request)));
    }

    @GetMapping("/user/members")
    public ResponseEntity<ResponseDto> getMember(@RequestParam String memberId) throws Exception {

        return ResponseEntity.ok().body(new ResponseDto(HttpStatus.OK, "회원 상세 조회 성공!", memberService.getMember(memberId)));
    }

}

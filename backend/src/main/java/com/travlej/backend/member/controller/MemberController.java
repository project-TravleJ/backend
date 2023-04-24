package com.travlej.backend.member.controller;

import com.travlej.backend.common.ResponseDto;
import com.travlej.backend.member.dto.MemberDTO;
import com.travlej.backend.member.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(value = "/api/v1", produces = "application/json;charset=UTF-8")
public class MemberController {

    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/members")
    public ResponseEntity<ResponseDto> findMemberList() {

        return ResponseEntity.ok().body(new ResponseDto(HttpStatus.OK, "회원 전체 조회 성공!", memberService.findMemberList()));
    }

    @GetMapping ("/members/{memberCode}")
    public ResponseEntity<ResponseDto> findMemberByCode(@PathVariable Long memberCode) {

        return ResponseEntity.ok().body(new ResponseDto(HttpStatus.OK, "회원 상세 조회 성공!", memberService.findMemberByCode(memberCode)));
    }

    @PostMapping ("/members/searchMulti")
    public ResponseEntity<ResponseDto> SearchByMultiple(@RequestBody MemberDTO memberDTO){

        return ResponseEntity.ok().body(new ResponseDto(HttpStatus.OK, "상세 검색 성공!", memberService.SearchByMultiple(memberDTO)));
    }

    @PutMapping("/members/{memberCode}")
    public ResponseEntity<ResponseDto> updateMemberByCode(@PathVariable Long memberCode, @RequestBody MemberDTO memberDTO) {

        return ResponseEntity.ok().body(new ResponseDto(HttpStatus.CREATED, "회원 정보 수정 성공!", memberService.updateMember(memberCode, memberDTO)));
    }

    @GetMapping("/members/{socialLogin}/{socialId}")
    public ResponseEntity<ResponseDto> findBySocialId(@PathVariable String socialLogin, @PathVariable long socialId) {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));

        MemberDTO foundMember = memberService.findBySocialId(socialLogin, socialId);

        Map<String, Object> responseMap = new HashMap<>();
        responseMap.put("member", foundMember);

        return ResponseEntity.ok().body(new ResponseDto(HttpStatus.OK, "소셜 아이디 검색 성공!", responseMap));
    }

}

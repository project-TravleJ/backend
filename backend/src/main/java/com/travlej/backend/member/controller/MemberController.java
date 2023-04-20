package com.travlej.backend.member.controller;

import com.travlej.backend.common.ResponseDto;
import com.travlej.backend.common.paging.Pagenation;
import com.travlej.backend.member.dto.MemberDTO;
import com.travlej.backend.member.dto.SearchDTO;
import com.travlej.backend.member.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public ResponseEntity<ResponseDto> findMemberByCode(@PathVariable int memberCode) {

        return ResponseEntity.ok().body(new ResponseDto(HttpStatus.OK, "회원 상세 조회 성공!", memberService.findMemberByCode(memberCode)));
    }

    @PostMapping ("/members/searchMulti")
    public ResponseEntity<ResponseDto> SearchByMultiple(@RequestBody MemberDTO memberDTO){

        return ResponseEntity.ok().body(new ResponseDto(HttpStatus.OK, "상세 검색 성공!", memberService.SearchByMultiple(memberDTO)));
    }

    @PutMapping("/members/{memberCode}")
    public ResponseEntity<ResponseDto> updateMemberByCode(@PathVariable int memberCode, @RequestBody MemberDTO memberDTO) {

        return ResponseEntity.ok().body(new ResponseDto(HttpStatus.OK, "회원 정보 수정 성공!", memberService.updateMember(memberCode, memberDTO)));
    }

    @PostMapping ("/members/searchMultiple")
    public ResponseEntity<ResponseDto> getMenus(@RequestBody SearchDTO searchDTO) {

        return ResponseEntity.ok().body(new ResponseDto(HttpStatus.OK, "상세 검색 성공!", memberService.selectMemberByMultiple(searchDTO)));
    }

}

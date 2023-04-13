package com.travlej.backend.member.controller;

import com.travlej.backend.common.ResponseDto;
import com.travlej.backend.common.paging.Pagenation;
import com.travlej.backend.member.dto.MemberDTO;
import com.travlej.backend.member.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/v1")
public class MemberController {

    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping ("/members/{memberCode}")
    public ResponseEntity<ResponseDto> findMemberByCode(@PathVariable int memberCode) {

        return ResponseEntity.ok().body(new ResponseDto(HttpStatus.OK, "회원 상세 조회 성공!", memberService.findMemberByCode(memberCode)));
    }

//    @GetMapping("/member")
//    public ResponseEntity<ResponseDto> findMemberListWithPaging(@PageableDefault Pageable pageable) {
//
//        Page<MemberDTO> menuList = memberService.findMemberList(pageable);
//
////        int totalCount = memberService.findMemberTotal();
////        int limit = 10;
////        int buttonAmount = 5;
////        SelectCriteria selectCriteria = Pagenation.getSelectCriteria(Integer.parseInt(offset), totalCount, limit, buttonAmount);
////
////        ResponseMessageWithPaging responseMessageWithPaging = new ResponseMessageWithPaging();
////        responseMessageWithPaging.setPageInfo(selectCriteria);
////        responseMessageWithPaging.setData(memberService.findMemberListWithPaging(selectCriteria));
//
//        return ResponseEntity.ok().body(new ResponseDto(HttpStatus.OK, "회원 전체 조회 성공!", memberService.findMemberList()));
//    }
}

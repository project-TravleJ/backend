//package com.travlej.backend.member.dto;
//
//import com.travlej.backend.member.entity.Member;
//import lombok.AllArgsConstructor;
//import lombok.Builder;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Getter
//@Builder @AllArgsConstructor @NoArgsConstructor
//public class ResponseDTO {
//
//    private Long memberCode;
//    private String memberNickname;
//    private String status;
//    private String grade;
//    private String joinDate;
//    private String lastAccessDate;
//    private String token;
//
//    public ResponseDTO(Member member) {
//        this.memberCode = member.getMemberCode();
//        this.memberNickname = member.getMemberNickname();
//        this.status = member.getStatus();
//        this.grade = member.getGrade();
//        this.joinDate = member.getJoinDate();
//        this.lastAccessDate = member.getLastAccessDate();
////        this.token = member.getToken();
//    }
//}

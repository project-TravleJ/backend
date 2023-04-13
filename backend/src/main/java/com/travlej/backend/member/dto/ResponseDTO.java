package com.travlej.backend.member.dto;

import com.travlej.backend.member.entity.Authority;
import com.travlej.backend.member.entity.Member;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@Builder @AllArgsConstructor @NoArgsConstructor
public class ResponseDTO {

    private int memberCode;
    private String memberId;
    private String memberNickname;
    private int status;
    private String grade;
    private String joinDate;
    private String lastAccessDate;
    @Builder.Default
    private List<Authority> roles = new ArrayList<>();
    private String token;

    public ResponseDTO(Member member) {
        this.memberCode = member.getMemberCode();
        this.memberId = member.getMemberId();
        this.memberNickname = member.getMemberNickname();
        this.status = member.getStatus();
        this.grade = member.getGrade();
        this.joinDate = member.getJoinDate();
        this.lastAccessDate = member.getLastAccessDate();
        this.roles = member.getRoles();
    }
}

package com.travlej.backend.member.dto;

import com.travlej.backend.member.entity.Authority;
import com.travlej.backend.member.entity.Member;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder @AllArgsConstructor @NoArgsConstructor
public class MemberDTO {

    private int memberCode;
    private String memberId;
    private String memberNickname;
    private String memberPwd;
    private int status;
    private String grade;
    private String joinDate;
    private String lastAccessDate;
    @Builder.Default
    private List<Authority> roles = new ArrayList<>();
    private String token;

    public MemberDTO(Member member) {
        this.memberCode = member.getMemberCode();
        this.memberId = member.getMemberId();
        this.memberNickname = member.getMemberNickname();
        this.memberPwd = member.getMemberPwd();
        this.status = member.getStatus();
        this.grade = member.getGrade();
        this.joinDate = member.getJoinDate();
        this.lastAccessDate = member.getLastAccessDate();
        this.roles = member.getRoles();
    }


}

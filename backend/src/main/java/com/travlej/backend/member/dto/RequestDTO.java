package com.travlej.backend.member.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RequestDTO {
    private String memberId;

    private String memberNickname;

    private String memberPwd;
}

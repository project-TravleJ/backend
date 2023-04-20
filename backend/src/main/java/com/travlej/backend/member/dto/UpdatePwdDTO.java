package com.travlej.backend.member.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class UpdatePwdDTO {

    private String originPwd;
    private String newPwd;
    private String checkNewPwd;
}

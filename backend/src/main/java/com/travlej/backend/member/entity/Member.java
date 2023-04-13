//package com.travlej.backend.member.entity;
//
//import lombok.AllArgsConstructor;
//import lombok.Builder;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//
//import javax.persistence.*;
//import java.util.ArrayList;
//import java.util.List;
//
//@Entity(name = "Member")
//@Table(name = "member")
//@Getter
//@Builder @AllArgsConstructor @NoArgsConstructor
//@SequenceGenerator(
//        name = "MEMBER_SEQ_GENERATOR",
//        sequenceName = "SEQ_MEMBER_CODE",
//        initialValue = 1,
//        allocationSize = 1
//)
//public class Member {
//    @Id
//    @GeneratedValue(
//            strategy = GenerationType.SEQUENCE,
//            generator = "MEMBER_SEQ_GENERATOR"
//    )
//    @Column(name = "MEMBER_CODE")
//    private int memberCode;
//
//    @Column(name = "MEMBER_ID", unique = true)
//    private String memberId;
//
//    @Column(name = "MEMBER_NICKNAME", unique = true)
//    private String memberNickname;
//
//    @Column(name = "MEMBER_PWD")
//    private String memberPwd;
//
//    @Column(name = "STATUS")
//    private int status;
//
//    @Column(name = "GRADE")
//    private String grade;
//
//    @Column(name = "JOIN_DATE")
//    private String joinDate;
//
//    @Column(name = "LAST_ACCESS_DATE")
//    private String lastAccessDate;
//
//    @OneToMany(mappedBy = "member", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//    @Builder.Default
//    private List<Authority> roles = new ArrayList<>();
//
//    public void setRoles(List<Authority> role) {
//        this.roles = role;
//        role.forEach(o -> o.setMember(this));
//    }
//
//}

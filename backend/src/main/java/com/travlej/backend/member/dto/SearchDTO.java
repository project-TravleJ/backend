package com.travlej.backend.member.dto;

public class SearchDTO {

    private int memberCode;
    private String memberNickname;
//    private int status;
//    private String grade;
    private String joinDate;
    private String lastAccessDate;

    public SearchDTO() {}

    public SearchDTO(int memberCode, String memberNickname, int status, String grade, String joinDate, String lastAccessDate) {
        this.memberCode = memberCode;
        this.memberNickname = memberNickname;
//        this.status = status;
//        this.grade = grade;
        this.joinDate = joinDate;
        this.lastAccessDate = lastAccessDate;
    }

    public int getMemberCode() {
        return memberCode;
    }

    public void setMemberCode(int memberCode) {
        this.memberCode = memberCode;
    }

    public String getMemberNickname() {
        return memberNickname;
    }

    public void setMemberNickname(String memberNickname) {
        this.memberNickname = memberNickname;
    }

//    public int getStatus() {
//        return status;
//    }
//
//    public void setStatus(int status) {
//        this.status = status;
//    }
//
//    public String getGrade() {
//        return grade;
//    }
//
//    public void setGrade(String grade) {
//        this.grade = grade;
//    }

    public String getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(String joinDate) {
        this.joinDate = joinDate;
    }

    public String getLastAccessDate() {
        return lastAccessDate;
    }

    public void setLastAccessDate(String lastAccessDate) {
        this.lastAccessDate = lastAccessDate;
    }

    @Override
    public String toString() {
        return "SearchDTO{" +
                "memberCode=" + memberCode +
                ", memberNickname='" + memberNickname + '\'' +
//                ", status=" + status +
//                ", grade='" + grade + '\'' +
                ", joinDate='" + joinDate + '\'' +
                ", lastAccessDate='" + lastAccessDate + '\'' +
                '}';
    }
}

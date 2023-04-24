package com.travlej.backend.member.dto;

import java.time.LocalDateTime;

public class MemberDTO {

    private Long memberCode;
    private String memberNickname;
    private String imageSource;
    private int reportCount;
    private String socialLogin;
    private long socialId;
    private String accessToken;
    private long accessTokenExpireDate;
    private String refreshToken;
    private long refreshTokenExpireDate;
    private String email;
    private LocalDateTime signUpDate;
    private String gender;
    private String status;
    private String grade;
    private String joinDate;
    private String lastAccessDate;

    public MemberDTO() {}

    public MemberDTO(Long memberCode, String memberNickname, String imageSource, int reportCount, String socialLogin, long socialId, String accessToken, long accessTokenExpireDate, String refreshToken, long refreshTokenExpireDate, String email, LocalDateTime signUpDate, String gender, String status, String grade, String joinDate, String lastAccessDate) {
        this.memberCode = memberCode;
        this.memberNickname = memberNickname;
        this.imageSource = imageSource;
        this.reportCount = reportCount;
        this.socialLogin = socialLogin;
        this.socialId = socialId;
        this.accessToken = accessToken;
        this.accessTokenExpireDate = accessTokenExpireDate;
        this.refreshToken = refreshToken;
        this.refreshTokenExpireDate = refreshTokenExpireDate;
        this.email = email;
        this.signUpDate = signUpDate;
        this.gender = gender;
        this.status = status;
        this.grade = grade;
        this.joinDate = joinDate;
        this.lastAccessDate = lastAccessDate;
    }

    public Long getMemberCode() {
        return memberCode;
    }

    public void setMemberCode(Long memberCode) {
        this.memberCode = memberCode;
    }

    public String getMemberNickname() {
        return memberNickname;
    }

    public void setMemberNickname(String memberNickname) {
        this.memberNickname = memberNickname;
    }

    public String getImageSource() {
        return imageSource;
    }

    public void setImageSource(String imageSource) {
        this.imageSource = imageSource;
    }

    public int getReportCount() {
        return reportCount;
    }

    public void setReportCount(int reportCount) {
        this.reportCount = reportCount;
    }

    public String getSocialLogin() {
        return socialLogin;
    }

    public void setSocialLogin(String socialLogin) {
        this.socialLogin = socialLogin;
    }

    public long getSocialId() {
        return socialId;
    }

    public void setSocialId(long socialId) {
        this.socialId = socialId;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public long getAccessTokenExpireDate() {
        return accessTokenExpireDate;
    }

    public void setAccessTokenExpireDate(long accessTokenExpireDate) {
        this.accessTokenExpireDate = accessTokenExpireDate;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public long getRefreshTokenExpireDate() {
        return refreshTokenExpireDate;
    }

    public void setRefreshTokenExpireDate(long refreshTokenExpireDate) {
        this.refreshTokenExpireDate = refreshTokenExpireDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDateTime getSignUpDate() {
        return signUpDate;
    }

    public void setSignUpDate(LocalDateTime signUpDate) {
        this.signUpDate = signUpDate;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

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
        return "MemberDTO{" +
                "memberCode=" + memberCode +
                ", memberNickname='" + memberNickname + '\'' +
                ", imageSource='" + imageSource + '\'' +
                ", reportCount=" + reportCount +
                ", socialLogin='" + socialLogin + '\'' +
                ", socialId=" + socialId +
                ", accessToken='" + accessToken + '\'' +
                ", accessTokenExpireDate=" + accessTokenExpireDate +
                ", refreshToken='" + refreshToken + '\'' +
                ", refreshTokenExpireDate=" + refreshTokenExpireDate +
                ", email='" + email + '\'' +
                ", signUpDate=" + signUpDate +
                ", gender='" + gender + '\'' +
                ", status='" + status + '\'' +
                ", grade='" + grade + '\'' +
                ", joinDate='" + joinDate + '\'' +
                ", lastAccessDate='" + lastAccessDate + '\'' +
                '}';
    }
}

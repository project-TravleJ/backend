package com.travlej.backend.member.entity;

import org.hibernate.annotations.ColumnDefault;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "Member")
@Table(name = "member")
@SequenceGenerator(
        name = "MEMBER_SEQ_GENERATOR",
        sequenceName = "SEQ_MEMBER_CODE",
        initialValue = 1,
        allocationSize = 1
)
public class Member {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "MEMBER_SEQ_GENERATOR"
    )
    @Column(name = "MEMBER_CODE")
    private Long memberCode;

    @Column(name = "MEMBER_NICKNAME", unique = true)
    private String memberNickname;

    @Column(name = "IMAGE_SOURCE")
    private String imageSource;

    @Column(name = "REPORT_COUNT")
    private int reportCount;

    @Column(name = "SOCIAL_LOGIN")
    private String socialLogin;

    @Column(name = "SOCIAL_ID")
    private long socialId;

    @Column(name = "ACCESS_TOKEN")
    private String accessToken;

    @Column(name = "ACCESS_TOKEN_EXPIRE_DATE")
    private long accessTokenExpireDate;

    @Column(name = "REFRESH_TOKEN")
    private String refreshToken;

    @Column(name = "REFRESH_TOKEN_EXPIRE_DATE")
    private long refreshTokenExpireDate;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "GENDER")
    private String gender;

    @Column(name = "STATUS")
    @ColumnDefault("정상")
    private String status;

    @Column(name = "GRADE")
    @ColumnDefault("일반")
    private String grade;

    @CreatedDate
    @Column(name = "JOIN_DATE")
    private String joinDate;

    @LastModifiedDate
    @Column(name = "LAST_ACCESS_DATE")
    private String lastAccessDate;

    @PrePersist
    public void onPrePersist(){
        this.joinDate = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        this.lastAccessDate = this.joinDate;
}

    @PreUpdate
    public void onPreUpdate(){
        this.lastAccessDate = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
}

    public Member() {}

    public Member(Long memberCode, String memberNickname, String imageSource, int reportCount, String socialLogin, long socialId, String accessToken, long accessTokenExpireDate, String refreshToken, long refreshTokenExpireDate, String email, String gender, String status, String grade, String joinDate, String lastAccessDate) {
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
        return "Member{" +
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
                ", gender='" + gender + '\'' +
                ", status='" + status + '\'' +
                ", grade='" + grade + '\'' +
                ", joinDate='" + joinDate + '\'' +
                ", lastAccessDate='" + lastAccessDate + '\'' +
                '}';
    }
}
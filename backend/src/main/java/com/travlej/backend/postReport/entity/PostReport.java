package com.travlej.backend.postReport.entity;


import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Entity(name = "PostReport")
@Table(name = "POST_REPORT")
@SequenceGenerator(
        name = "REPORT_POST_GENERATOR",
        sequenceName = "SEQ_REPORT_POST_ID",
        initialValue = 1,
        allocationSize = 1
)
public class PostReport {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "REPORT_POST_GENERATOR"
    )
    @Column(name = "REPORT_ID")
    private int reportId;
    @Column(name = "REPORT_WRITER")
    private String reportWriter;
    @Column(name = "REPORT_TO_MEMBER")
    private String reportToMember;
    @CreatedDate
    @Column(name = "REPORT_DATE")
    private String reportDate;
    @Column(name = "REPORT_REASON")
    private String reportReason;
    @Column(name = "REPORT_DETAILS")
    private String reportDetails;
    @Column(name = "REPORT_MANAGEMENT")
    private String reportManagement;
    @Column(name = "REPORT_POST_ID")
    private int reportPostId;

    public PostReport() {}

    public PostReport(int reportId, String reportWriter, String reportToMember, String reportDate, String reportReason, String reportDetails, String reportManagement, int reportPostId) {
        this.reportId = reportId;
        this.reportWriter = reportWriter;
        this.reportToMember = reportToMember;
        this.reportDate = reportDate;
        this.reportReason = reportReason;
        this.reportDetails = reportDetails;
        this.reportManagement = reportManagement;
        this.reportPostId = reportPostId;
    }

    public int getReportId() {
        return reportId;
    }

    public void setReportId(int reportId) {
        this.reportId = reportId;
    }

    public String getReportWriter() {
        return reportWriter;
    }

    public void setReportWriter(String reportWriter) {
        this.reportWriter = reportWriter;
    }

    public String getReportToMember() {
        return reportToMember;
    }

    public void setReportToMember(String reportToMember) {
        this.reportToMember = reportToMember;
    }

    public String getReportDate() {
        return reportDate;
    }

    public void setReportDate(String reportDate) {
        this.reportDate = reportDate;
    }

    public String getReportReason() {
        return reportReason;
    }

    public void setReportReason(String reportReason) {
        this.reportReason = reportReason;
    }

    public String getReportDetails() {
        return reportDetails;
    }

    public void setReportDetails(String reportDetails) {
        this.reportDetails = reportDetails;
    }

    public String getReportManagement() {
        return reportManagement;
    }

    public void setReportManagement(String reportManagement) {
        this.reportManagement = reportManagement;
    }

    public int getReportPostId() {
        return reportPostId;
    }

    public void setReportPostId(int reportPostId) {
        this.reportPostId = reportPostId;
    }

    @Override
    public String toString() {
        return "PostReport{" +
                "reportId=" + reportId +
                ", reportWriter='" + reportWriter + '\'' +
                ", reportToMember='" + reportToMember + '\'' +
                ", reportDate=" + reportDate +
                ", reportReason='" + reportReason + '\'' +
                ", reportDetails='" + reportDetails + '\'' +
                ", reportManagement='" + reportManagement + '\'' +
                ", reportPostId=" + reportPostId +
                '}';
    }

    @PrePersist
    public void onPrePersist(){
        this.reportDate = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }
}


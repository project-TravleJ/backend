package com.travlej.backend.postReport.dto;

import java.util.Date;

public class PostReportDTO {

    private int reportId;
    private String reportWriter;
    private String reportToMember;
    private String reportDate;
    private String reportReason;
    private String reportDetails;
    private String reportManagement;
    private int reportPostId;

    private java.util.Date postStart;
    private java.util.Date postEnd;

    public PostReportDTO () {}

    public PostReportDTO(int reportId, String reportWriter, String reportToMember, String reportDate, String reportReason, String reportDetails, String reportManagement, int reportPostId) {
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
        return "PostReportDTO{" +
                "reportId=" + reportId +
                ", reportWriter='" + reportWriter + '\'' +
                ", reportToMember='" + reportToMember + '\'' +
                ", reportDate=" + reportDate +
                ", reportReason='" + reportReason + '\'' +
                ", reportDetails='" + reportDetails + '\'' +
                ", reportManagement='" + reportManagement + '\'' +
                ", PostId=" + reportPostId +
                '}';
    }
}

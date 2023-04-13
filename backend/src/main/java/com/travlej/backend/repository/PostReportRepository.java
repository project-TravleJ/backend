package com.travlej.backend.repository;

import com.travlej.backend.postReport.entity.PostReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface PostReportRepository extends JpaRepository<PostReport, Integer> {

    @Query(value = "SELECT R.REPORT_ID, R.REPORT_WRITER, R.REPORT_TO_MEMBER, R.REPORT_DATE, R.REPORT_REASON, R.REPORT_DETAILS, R.REPORT_MANAGEMENT, R.REPORT_POST_ID FROM POST_REPORT R ORDER BY R.REPORT_ID ASC",
            nativeQuery = true)
    List<PostReport> findAllPostReport();

    @Query(value = "SELECT R.REPORT_ID, R.REPORT_WRITER, R.REPORT_TO_MEMBER, R.REPORT_DATE, R.REPORT_REASON, R.REPORT_DETAILS, R.REPORT_MANAGEMENT, R.REPORT_POST_ID " +
            "FROM POST_REPORT R " +
            "WHERE R.REPORT_WRITER LIKE :reportWriter " +
            "ORDER BY REPORT_DATE DESC"
            , nativeQuery = true)
        List<PostReport> findByWriter(@Param("reportWriter")String reportWriter);






}



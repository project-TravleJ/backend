package com.travlej.backend.postrequest.request.repository;

import com.travlej.backend.postrequest.request.entity.Request;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RequestRepository extends JpaRepository<Request, Integer> {

    List<Request> findByTitleContaining(String title);

    @Query(value="SELECT R.REQUEST_ID, R.TITLE, R.DATE, R.WRITER, R.CONTEXT, R.REQUEST_MANAGEMENT " +
            "FROM REQUEST R " +
            "WHERE R.TITLE LIKE :title " +
            "ORDER BY R.DATE DESC", nativeQuery = true)
    List<Request> findByRequestTitle(@Param("title")String title);


    @Query(value="UPDATE REQUEST R " +
            "SET R.DATE = :date, R.TITLE = :title, R.CONTEXT = :context " +
            "WHERE REQUEST_MANAGEMENT LIKE :requestManagement", nativeQuery = true)
    List<Request> findByManagement(@Param("requestManagement")String requestManagement);
}

package com.travlej.backend.postrequest.request.repository;

import com.travlej.backend.postrequest.request.entity.Request;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RequestRepository extends JpaRepository<Request, Integer> {

    List<Request> findByTitleContaining(String title);

    List<Request> findByWriterContainingAndTitleContainingAndRequestManagementContaining(String writer, String title, String requestManagement);

    @Query(value="UPDATE REQUEST R " +
            "SET R.REQUEST_MANAGEMENT :requestManagement " +
            "WHERE REQUEST_ID LIKE : requestId ", nativeQuery = true)
    List<Request> findByManagement(@Param("requestManagement")String requestManagement);
}


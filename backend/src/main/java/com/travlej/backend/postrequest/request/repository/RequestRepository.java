package com.travlej.backend.postrequest.request.repository;

import com.travlej.backend.postrequest.request.dto.RequestDTO;
import com.travlej.backend.postrequest.request.entity.Request;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RequestRepository extends JpaRepository<Request, Integer> {

    List<Request> findByTitleContaining(String title);

    Page<Request> findByWriterContainingAndTitleContainingAndRequestManagementContaining(String writer, String title, String requestManagement,Pageable pageable);

    @Query(value="UPDATE REQUEST R " +
            "SET R.REQUEST_MANAGEMENT :requestManagement " +
            "WHERE REQUEST_ID LIKE : requestId ", nativeQuery = true)
    List<Request> findByManagement(@Param("requestManagement")String requestManagement);


//    @Query("SELECT new com.travlej.backend.postrequest.request.dto.RequestDTO(r.requestId, r.title, r.context, r.writer, r.date, r.requestManagement) FROM Request r ORDER BY r.requestId DESC")
//    Page<RequestDTO> findSimpleRequestList(Pageable pageable);

}
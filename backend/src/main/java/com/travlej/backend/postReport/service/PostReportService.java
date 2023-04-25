package com.travlej.backend.postReport.service;

import com.travlej.backend.postReport.dto.PostReportDTO;
import com.travlej.backend.postReport.entity.PostReport;
import com.travlej.backend.postrequest.request.dto.RequestDTO;
import com.travlej.backend.postReport.repository.PostReportRepository;
import com.travlej.backend.postrequest.request.entity.Request;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostReportService {

    private final PostReportRepository postReportRepository;
    private final ModelMapper modelMapper;


    @Autowired
    public PostReportService(PostReportRepository postReportRepository, ModelMapper modelMapper) {
        this.postReportRepository = postReportRepository;
        this.modelMapper = modelMapper;
    }

    @Transactional
    public PostReportDTO registNewPost(PostReportDTO postReportDTO) {

        postReportRepository.save(modelMapper.map(postReportDTO, PostReport.class));

        PostReport result = postReportRepository.findByWriter(postReportDTO.getReportWriter()).get(0);

        return modelMapper.map(result, PostReportDTO.class);
    }

    @Transactional
    public PostReportDTO updatePostReport(int reportId, PostReportDTO updatePostReport) {

        PostReport postReport = postReportRepository.findById(reportId).get();

        String reportManagement = updatePostReport.getReportManagement();

        if(!"".equals(reportManagement) && !postReport.getReportManagement().equals(reportManagement)){
            postReport.setReportManagement(reportManagement);
        }

        PostReport result = postReportRepository.save(postReport);

        return modelMapper.map(result, PostReportDTO.class);
    }

    public Page<PostReportDTO> findAllPostReport(Pageable pageable) {

//        List<PostReport> postReportList = postReportRepository.findAllPostReport();

        //offset, limit, sort 순으로 값을 전달함
        pageable = PageRequest.of(pageable.getPageNumber() <= 0 ? 0: pageable.getPageNumber() - 1,
                pageable.getPageSize(),
                Sort.by("reportId").ascending());


        return postReportRepository.findAll(pageable).map(postReport -> modelMapper.map(postReport, PostReportDTO.class));
//        return postReportList.stream().map(postReport -> modelMapper.map(postReport, PostReportDTO.class)).collect(Collectors.toList());
    }



    public PostReportDTO findOnePostReport(int postReportId){

        PostReport postReport = postReportRepository.findById(postReportId).get();

        return modelMapper.map(postReport, PostReportDTO.class);
    }
    @Transactional
    public Object deletePostReport(int reportId) {

        postReportRepository.deleteById(reportId);

        return null;
    }

    public Page<PostReportDTO> SearchByReportMultiple(PostReportDTO postReportDTO, Pageable pageable){

        Page<PostReport> postReportPage = postReportRepository.findByReportWriterContainingAndReportToMemberContainingAndReportDateContainingAndReportManagementContaining(
                postReportDTO.getReportWriter(), postReportDTO.getReportToMember(), postReportDTO.getReportDate(),postReportDTO.getReportManagement(), pageable);


        return postReportPage.map(postReport -> modelMapper.map(postReport, PostReportDTO.class));


    }
}


package com.travlej.backend.postReport.service;

import com.travlej.backend.postReport.dto.PostReportDTO;
import com.travlej.backend.postReport.entity.PostReport;
import com.travlej.backend.repository.PostReportRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
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

    public List<PostReportDTO> findAllPostReport() {

        List<PostReport> postReportList = postReportRepository.findAllPostReport();

        return postReportList.stream().map(postReport -> modelMapper.map(postReport, PostReportDTO.class)).collect(Collectors.toList());
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

    public List<PostReportDTO> detailSearchReport(PostReportDTO postReportDTO){

        List<PostReport> postReportList = postReportRepository.findByReportWriterContainingAndReportToMemberContainingAndReportDateContaining(postReportDTO.getReportWriter(), postReportDTO.getReportToMember(), postReportDTO.getReportDate());

        return postReportList.stream().map(PostReport -> modelMapper.map(PostReport, PostReportDTO.class)).collect(Collectors.toList());

}
}


package com.travlej.backend.postReport.service;

import com.travlej.backend.postReport.dto.PostReportDTO;
import com.travlej.backend.postReport.entity.PostReport;
import com.travlej.backend.repository.PostReportRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
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

    public List<PostReportDTO> findAllPostReport() {

        List<PostReport> postReportList = postReportRepository.findAllPostReport();

        return postReportList.stream().map(postReport -> modelMapper.map(postReport, PostReportDTO.class)).collect(Collectors.toList());
    }

}


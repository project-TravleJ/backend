package com.travlej.backend.postrequest.request.service;

import com.travlej.backend.postrequest.request.dto.RequestDTO;
import com.travlej.backend.postrequest.request.entity.Request;
import com.travlej.backend.postrequest.request.repository.RequestRepository;
import org.modelmapper.ModelMapper;
import org.mybatis.logging.Logger;
import org.mybatis.logging.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.Writer;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RequestService {

    private static final Logger log = LoggerFactory.getLogger(RequestService.class);

    private final RequestRepository requestRepository;

    private final ModelMapper modelMapper;

    @Autowired
    public RequestService(RequestRepository requestRepository, ModelMapper modelMapper) {
        this.requestRepository = requestRepository;
        this.modelMapper = modelMapper;
    }

    public Page<RequestDTO> findRequestList(Pageable pageable){

        //offset, limit, sort 순으로 값을 전달함
        pageable = PageRequest.of(pageable.getPageNumber() <= 0 ? 0: pageable.getPageNumber() - 1,
                pageable.getPageSize(),
                Sort.by("requestId").ascending());

//        return requestRepository.findSimpleRequestList(pageable);
          return requestRepository.findAll(pageable).map(request -> modelMapper.map(request, RequestDTO.class));
//        return requestList.stream().map(request -> modelMapper.map(request, RequestDTO.class)).collect(Collectors.toList());
    }


    public Page<RequestDTO> SearchByMultiple (RequestDTO requestDTO, Pageable pageable){

        Page<Request> requestPage = requestRepository.findByWriterContainingAndTitleContainingAndRequestManagementContaining(
                requestDTO.getWriter(), requestDTO.getTitle(), requestDTO.getRequestManagement(), pageable);

        return requestPage.map(request -> modelMapper.map(request, RequestDTO.class));
    }
//        Page<Request> requestList = requestRepository.findByWriterContainingAndTitleContainingAndRequestManagementContaining(requestDTO.getWriter(), requestDTO.getTitle(), requestDTO.getRequestManagement(), pageable);
//
//        pageable = PageRequest.of(pageable.getPageNumber() <= 0 ? 0: pageable.getPageNumber() - 1,
//                pageable.getPageSize(),
//                Sort.by("requestId").descending());
//
//        return requestRepository.findAll(pageable).map(request -> modelMapper.map(request, RequestDTO.class));
////        return requestList.stream().map(request -> modelMapper.map(request, RequestDTO.class)).collect(Collectors.toList());
//    }


//    public List<RequestDTO> SearchByMultiple (RequestDTO requestDTO){
//
//        List<Request> requestList = requestRepository.findByWriterContainingAndTitleContainingAndRequestManagementContaining(requestDTO.getWriter(), requestDTO.getTitle(), requestDTO.getRequestManagement());
//
//
//        return requestList.stream().map(request -> modelMapper.map(request, RequestDTO.class)).collect(Collectors.toList());
//}

    public RequestDTO findRequestByRequestId(int requestId){

        Request request = requestRepository.findById(requestId).get();

        return modelMapper.map(request, RequestDTO.class);
    }

    @Transactional
    public RequestDTO registNewRequest(RequestDTO newRequest){

        //저장하는 메소드 Repo.save()
        Request result = requestRepository.save(modelMapper.map(newRequest, Request.class));

        System.out.println(2);
        return modelMapper.map(result, RequestDTO.class);
    }


    @Transactional
    public RequestDTO updateRequest(int requestId, RequestDTO updateRequest) {

        // url의 requestId를 통해 기존에 있는 글을 찾아옴
        Request request = requestRepository.findById(requestId).get();

        // 입력받은 DTO를 통해 변경할 값들을 모두 추출함
        String requestManagement = updateRequest.getRequestManagement();

        // update값이 비어있지 않다면, 갱신함
        if(requestManagement != null && !requestManagement.isEmpty()){
            request.setRequestManagement(requestManagement);
        }

        Request result = requestRepository.save(request);

        return modelMapper.map(result, RequestDTO.class);
    }

    @Transactional
    public Object deleteRequest(int requestId){

        requestRepository.deleteById(requestId);

        return null;
    }


}

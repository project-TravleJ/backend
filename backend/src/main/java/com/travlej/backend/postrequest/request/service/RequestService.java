package com.travlej.backend.postrequest.request.service;

import com.travlej.backend.postrequest.request.dto.RequestDTO;
import com.travlej.backend.postrequest.request.entity.Request;
import com.travlej.backend.postrequest.request.repository.RequestRepository;
import org.modelmapper.ModelMapper;
import org.mybatis.logging.Logger;
import org.mybatis.logging.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
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

    public List<RequestDTO> findRequestList(){

        List<Request> requestList = requestRepository.findAll();

        return requestList.stream().map(request -> modelMapper.map(request, RequestDTO.class)).collect(Collectors.toList());
    }

    public RequestDTO findRequestByRequestId(int requestId){

        Request request = requestRepository.findById(requestId).get();

        return modelMapper.map(request, RequestDTO.class);
    }

    @Transactional
    public RequestDTO registNewRequest(RequestDTO newRequest){


        //저장하는 메소드 Repo.save()
        Request result = requestRepository.save(modelMapper.map(newRequest, Request.class));

        return modelMapper.map(result, RequestDTO.class);
    }

    @Transactional
    public RequestDTO updateRequest(int requestId, RequestDTO updateRequest) {

        // url의 requestId를 통해 기존에 있는 글을 찾아옴
        Request request = requestRepository.findById(requestId).get();

        // 입력받은 DTO를 통해 변경할 값들을 모두 추출함
        String requestManagement = updateRequest.getRequestManagement();

        // update값이 비어있거나 기존과 같다면, 갱신하지 않는다.
        if(!"".equals(requestManagement) && !request.getRequestManagement().equals(requestManagement)){
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

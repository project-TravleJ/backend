package com.travlej.backend.attraction.service;

import com.travlej.backend.attraction.dto.AttractionDTO;
import com.travlej.backend.attraction.entity.Attraction;
import com.travlej.backend.attraction.repository.AttractionRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class AttractionService {

    private final AttractionRepository attractionRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public AttractionService(AttractionRepository attractionRepository, ModelMapper modelMapper){
        this.attractionRepository = attractionRepository;
        this.modelMapper = modelMapper;
    }

    public AttractionDTO findAttractionById(int attractionId){

        Attraction attraction = attractionRepository.findById(attractionId).get();

        return modelMapper.map(attraction, AttractionDTO.class);
    }

    public List<AttractionDTO> findAttractionList(){

        List<Attraction> attractionList = attractionRepository.findAll(Sort.by("attractionId"));
//        List<Attraction> attractionList = attractionRepository.findByAttractionNameContaining("금각사");

        return attractionList.stream().map(attraction -> modelMapper.map(attraction, AttractionDTO.class)).collect(Collectors.toList());
    }

    @Transactional
    public AttractionDTO registNewAttraction(AttractionDTO newAttraction) {

        Attraction result = attractionRepository.save(modelMapper.map(newAttraction, Attraction.class));

        return modelMapper.map(result, AttractionDTO.class);
    }
//    @Transactional
//    public void registNewAttraction(AttractionDTO newAttraction) {
//
//        attractionRepository.save(modelMapper.map(newAttraction, Attraction.class));
//    }
}











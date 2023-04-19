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

import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class AttractionService {

    @Autowired
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

    @Transactional
    public Object deleteAttraction(int attractionId){

        attractionRepository.deleteById(attractionId);

        return null;
    }

    @Transactional
    public AttractionDTO updateAttraction(int attractionId, AttractionDTO updateAttraction) {

        Attraction attraction = attractionRepository.findById(attractionId).get();

        int id = updateAttraction.getAttractionId();
        String name = updateAttraction.getAttractionName();
        double lat = updateAttraction.getAttractionLat();
        double lng = updateAttraction.getAttractionLng();
        String def = updateAttraction.getAttractionDef();

            attraction.setAttractionId(id);

        if(!"".equals(name) && !attraction.getAttractionName().equals(name)) {
            attraction.setAttractionName(name);
        }

        if((0.0!=lat) && (attraction.getAttractionLat()!=lat)){
            attraction.setAttractionLat(lat);
        }
        if((0.0!=lng) && (attraction.getAttractionLat()!=lng)) {
            attraction.setAttractionLng(lng);
        }
        if((null!=def) && !attraction.getAttractionDef().equals(def)) {
            attraction.setAttractionDef(def);
        }

//        java.util.Date date = new Date();
//        attraction.setAttractionDate(date);

        Attraction result = attractionRepository.save(attraction);

        return modelMapper.map(result, AttractionDTO.class);
    }
}











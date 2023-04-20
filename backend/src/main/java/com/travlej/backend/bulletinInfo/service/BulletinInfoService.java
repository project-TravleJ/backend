package com.travlej.backend.bulletinInfo.service;

import com.travlej.backend.bulletinInfo.dto.BulletinInfoDTO;
import com.travlej.backend.bulletinInfo.entity.BulletinInfo;
import com.travlej.backend.bulletinInfo.repository.BulletinInfoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BulletinInfoService {

    private final BulletinInfoRepository bulletinInfoRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public BulletinInfoService(BulletinInfoRepository bulletinInfoRepository, ModelMapper modelMapper){
        this.bulletinInfoRepository = bulletinInfoRepository;
        this.modelMapper = modelMapper;
    }

    public BulletinInfoDTO findBulletinInfoByCode(int bulletinInfoCode) {

        BulletinInfo bulletinInfo = bulletinInfoRepository.findById(bulletinInfoCode).get();

        return modelMapper.map(bulletinInfo, BulletinInfoDTO.class);
    }

    public List<BulletinInfoDTO> findBulletinInfoList(){

        List<BulletinInfo> bulletinInfoList = bulletinInfoRepository.findAll(Sort.by("bulletinInfoCode"));

        return bulletinInfoList.stream().map(bulletinInfo -> modelMapper.map(bulletinInfo, BulletinInfoDTO.class)).collect(Collectors.toList());
    }
}
















package com.travlej.backend.bulletinInfo.controller;

import com.travlej.backend.bulletinInfo.service.BulletinInfoService;
import com.travlej.backend.common.ResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/v1/bulletinInfo")
public class BulletinInfoController {

    private final BulletinInfoService bulletinInfoService;

    @Autowired
    public BulletinInfoController(BulletinInfoService bulletinInfoService) {
        this.bulletinInfoService = bulletinInfoService;
    }

    @GetMapping("/{bulletinInfoCode}")
    public ResponseEntity<ResponseDto> selectBulletinInfoByBulletinInfoCode(@PathVariable int bulletinInfoCode){

        return ResponseEntity.ok().body(new ResponseDto(HttpStatus.OK, "게시판정보 상세조회", bulletinInfoService.findBulletinInfoByCode(bulletinInfoCode)));
    }

    @GetMapping("/list")
    public ResponseEntity<ResponseDto> selectBulletinInfoAll(){

        return ResponseEntity.ok().body(new ResponseDto(HttpStatus.OK, "게시판정보 리스트", bulletinInfoService.findBulletinInfoList()));
    }
}

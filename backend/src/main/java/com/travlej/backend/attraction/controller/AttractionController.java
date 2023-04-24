package com.travlej.backend.attraction.controller;

import com.travlej.backend.attraction.dto.AttractionDTO;
import com.travlej.backend.attraction.entity.Attraction;
import com.travlej.backend.attraction.repository.AttractionRepository;
//import com.travlej.backend.attraction.service.AttractionService;
import com.travlej.backend.attraction.service.AttractionService;
import com.travlej.backend.common.ResponseDto;
import com.travlej.backend.post.dto.PostDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/api/v1/attraction")
public class AttractionController {

        @Autowired
        private AttractionRepository attractionRepository;

    private final AttractionService attractionService;

    @Autowired
    public AttractionController(AttractionService attractionService) {
        this.attractionService = attractionService;}

    @GetMapping("/{attractionId}")
    public ResponseEntity<ResponseDto> selectAttractionByAttractionId(@PathVariable int attractionId){

        return ResponseEntity.ok().body(new ResponseDto(HttpStatus.OK, "어트랙션 상세조회", attractionService.findAttractionById(attractionId)));
    }

    @GetMapping("/list")
    public ResponseEntity<ResponseDto> selectAttractionAll() {

        return ResponseEntity.ok().body(new ResponseDto(HttpStatus.OK, "어트랙션 리스트", attractionService.findAttractionList()));
    }

    @GetMapping("/regist")
    public void registPage(){}

    @PostMapping("/regist")
    public ResponseEntity<ResponseDto> registAttraction(@RequestBody AttractionDTO attractionDTO){

        return ResponseEntity.ok().body(new ResponseDto(HttpStatus.OK, "어트랙션 등록 성공", attractionService.registNewAttraction(attractionDTO)));
    }


    @PutMapping("/{attractionId}")
    public ResponseEntity<ResponseDto> updateAttraction(@PathVariable int attractionId, @RequestBody AttractionDTO attractionDTO) {

        return ResponseEntity.ok().body(new ResponseDto(HttpStatus.OK, "어트랙션 수정 성공", attractionService.updateAttraction(attractionId, attractionDTO)));
    }

    @DeleteMapping("/{attractionId}")
    public ResponseEntity<ResponseDto> deleteAttraction(@PathVariable int attractionId) {

        return ResponseEntity.ok().body(new ResponseDto(HttpStatus.OK, "어트랙션 삭제 성공", attractionService.deleteAttraction(attractionId)));
    }

    @GetMapping("/search")
    public ResponseEntity<ResponseDto> searchByTitle(@RequestParam String value){

        return ResponseEntity.ok().body(new ResponseDto(HttpStatus.OK, "어트랙션 조회 성공", attractionService.findAttractionByTitle(value)));
    }
}

//@RestController
//public class AttractionController {
//    @Autowired
//    private AttractionRepository attractionRepository;
//
//    @GetMapping("/attractions")
//    public List<Attraction> getAllAttractions() {
//        return attractionRepository.findAll();
//    }
//}
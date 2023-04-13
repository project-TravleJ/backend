package com.travlej.backend.attraction.controller;

import com.travlej.backend.attraction.dto.AttractionDTO;
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
@RequestMapping("/attraction")
public class AttractionController {

    private final AttractionService attractionService;

    @Autowired
    public AttractionController(AttractionService attractionService) {
        this.attractionService = attractionService;}

    @GetMapping("/{attractionId}")
    public ModelAndView findAttractionById(ModelAndView mv, @PathVariable int attractionId){

       AttractionDTO attraction = attractionService.findAttractionById(attractionId);

       mv.addObject("attraction", attraction);
       mv.setViewName("/attraction/one");

        return mv;
        }

    @GetMapping("/list")
    public ModelAndView findAttractionList(ModelAndView mv) {

        List<AttractionDTO> attractionList = attractionService.findAttractionList();

        mv.addObject("attractionList", attractionList);
        mv.setViewName("attraction/list");

        return mv;
    }

    @GetMapping("/regist")
    public void registPage(){}

    @PostMapping("/regist")
    public ResponseEntity<ResponseDto> registAttraction(@RequestBody AttractionDTO attractionDTO){

        return ResponseEntity.ok().body(new ResponseDto(HttpStatus.OK, "어트랙션 등록 성공", attractionService.registNewAttraction(attractionDTO)));
    }

//    @PostMapping("/regist")
//    public ModelAndView registAttraction(ModelAndView mv, AttractionDTO newAttraction, RedirectAttributes rttr) {
//
//        attractionService.registNewAttraction(newAttraction);
//
//        rttr.addFlashAttribute("registSuccessMessage", "어트랙션 등록 성공");
//        mv.setViewName("redirect:/attraction/list");
//
//        return mv;
//    }
}

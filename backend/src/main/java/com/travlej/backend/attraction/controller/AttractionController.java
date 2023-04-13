package com.travlej.backend.attraction.controller;

import com.travlej.backend.attraction.dto.AttractionDTO;
import com.travlej.backend.attraction.service.AttractionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

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
}

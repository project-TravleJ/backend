package com.travlej.backend.course.service;

import com.travlej.backend.attraction.dto.AttractionDTO;
import com.travlej.backend.attraction.entity.Attraction;
import com.travlej.backend.course.dto.CourseDTO;
import com.travlej.backend.course.entity.Course;
import com.travlej.backend.course.repository.CourseRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseService {

    private final CourseRepository courseRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public CourseService(CourseRepository courseRepository, ModelMapper modelMapper) {
        this.courseRepository = courseRepository;
        this.modelMapper = modelMapper;
    }

    public List<CourseDTO> findCourseByPostId(int postId){

        List<Course> courseList = courseRepository.findByPost_PostId(postId);

        return courseList.stream().map(course -> modelMapper.map(course, CourseDTO.class)).collect(Collectors.toList());
    }

    @Transactional
    public CourseDTO registNewCourse(int postId, AttractionDTO attDTO) {

        Course result = new Course();

//        modelMapper(attDTO, Attraction.class)
//        result.setAttraction();
//                = courseRepository.save();

        return null;

        /* 작성중 */

    }
}

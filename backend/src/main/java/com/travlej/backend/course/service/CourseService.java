package com.travlej.backend.course.service;

import com.travlej.backend.attraction.dto.AttractionDTO;
import com.travlej.backend.attraction.entity.Attraction;
import com.travlej.backend.attraction.repository.AttractionRepository;
import com.travlej.backend.course.dto.CourseDTO;
import com.travlej.backend.course.entity.Course;
import com.travlej.backend.course.repository.CourseRepository;
import com.travlej.backend.post.dto.PostDTO;
import com.travlej.backend.post.entity.Post;
import com.travlej.backend.post.repository.PostRepository;
import com.travlej.backend.post.service.PostService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseService {

    private final CourseRepository courseRepository;
    private final ModelMapper modelMapper;

    @Autowired
    private PostRepository postRepository;
    @Autowired
    private AttractionRepository attractionRepository;

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
    public List<CourseDTO> registNewCourseList(int postId, List<CourseDTO> courseList) {

//        Post post = postRepository.findById(postId).get();
        for(CourseDTO courseDTO: courseList){
            courseDTO.setPostId(postId);
        }

        List<Course> courses = courseList.stream().map(courseDTO -> modelMapper.map(courseDTO, Course.class)).collect(Collectors.toList());

        for(Course course: courses){
//            course.setPost(post);
            courseRepository.save(course);
        }

        List<CourseDTO> resultList = courses.stream().map(course -> modelMapper.map(course, CourseDTO.class)).collect(Collectors.toList());

        return resultList;
    }

    @Transactional
    public List<Course> updateCourseList(Post post, List<CourseDTO> courseDTOList){

        List<Course> resultList = /* courseDTOList 변환 */ null;


        return null;
    }

    public List<CourseDTO> findCourses() {

        List<Course> result = courseRepository.findAll();

        return result.stream().map(course -> modelMapper.map(course, CourseDTO.class)).collect(Collectors.toList());
    }

    public String deleteCourses(int postId) {

        courseRepository.deleteByPost_PostId(postId);

        return postId + "의 post에 등록된 코스들이 삭제되었습니다.";
    }
}

package com.travlej.backend.post.service;

import com.travlej.backend.course.dto.CourseDTO;
import com.travlej.backend.course.entity.Course;
import com.travlej.backend.course.repository.CourseRepository;
import com.travlej.backend.course.service.CourseService;
import com.travlej.backend.post.dto.PostCourseDTO;
import com.travlej.backend.post.dto.PostDTO;
import com.travlej.backend.post.entity.Post;
import com.travlej.backend.post.repository.PostRepository;
import com.travlej.backend.postReport.dto.PostReportDTO;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostService {

    private static final Logger log = LoggerFactory.getLogger(PostService.class);

    private final PostRepository postRepository;

    private final ModelMapper modelMapper;

    @Autowired
    private CourseService courseService;

    @Autowired
    public PostService(PostRepository postRepository, ModelMapper modelMapper) {
        this.postRepository = postRepository;
        this.modelMapper = modelMapper;
    }

    public Page<PostDTO> findPostList(Pageable pageable){

//        Page<Post> postList = postRepository.findAll();
        pageable = PageRequest.of(pageable.getPageNumber() <= 0 ? 0: pageable.getPageNumber() - 1,
                 7,
                Sort.by("postId").ascending());


        return postRepository.findAll(pageable).map(post -> modelMapper.map(post, PostDTO.class));
//        return postList.stream().map(post -> modelMapper.map(post, PostDTO.class)).collect(Collectors.toList());
    }

    public PostDTO findPostByPostId(int postId){

        Post post = postRepository.findById(postId).get();

        return modelMapper.map(post, PostDTO.class);
    }

    public Post findPostEntityByPostId(int postId){

        return postRepository.findById(postId).get();
    }

    public List<PostDTO> findPostByPostTitle(String title){

        List<Post> postList = postRepository.findByPostTitleContaining(title);

        return postList.stream().map(post -> modelMapper.map(post, PostDTO.class)).collect(Collectors.toList());
    }

//    public List<PostCourseDTO> selectDetailSearch(PostCourseDTO postCourseDTO) {
//
//        List<Post> courseList = postRepository.findByWriterContainingAndPostDateAndattDTOListandLikes(postCourseDTO.getWriter(), postCourseDTO.getPostDate(), postCourseDTO.getAttDTOList(), postCourseDTO.getLikes());
//
//        return courseList.stream().map(post -> modelMapper.map(post, PostCourseDTO.class)).collect(Collectors.toList());
//    }

    // post create
    @Transactional
    public PostDTO registNewPost(PostDTO newPost){

        //저장하는 메소드 Repo.save()
        Post result = postRepository.save(modelMapper.map(newPost, Post.class));

        result.setPostDate(new java.util.Date());

        return modelMapper.map(result, PostDTO.class);
    }

    @Transactional
    public PostDTO updatePost(int postId, PostDTO updatePost) {

        // url의 postId를 통해 기존에 있는 글을 찾아옴
        Post post = postRepository.findById(postId).get();

        // 입력받은 DTO를 통해 변경할 값들을 모두 추출함
        String title = updatePost.getPostTitle();
        java.util.Date start = updatePost.getPostStart();
        java.util.Date end = updatePost.getPostEnd();
        List<CourseDTO> courseList = updatePost.getCourseList();
        String context = updatePost.getContext();

        // update값이 비어있거나 기존과 같다면, 갱신하지 않는다.
        if(!"".equals(title) && !post.getPostTitle().equals(title)){    // 다음과 동일 if( !("".equals.(title) && post.getPostTitle().equals(title) ) )
            post.setPostTitle(title);
        }
        if((null!=start) && !post.getPostStart().equals(start)) {
            post.setPostStart(start);
        }
        if((null!=end) && !post.getPostEnd().equals(end)){
            post.setPostEnd(end);
        }
        if((null!=courseList || courseList.size()==0) && !post.getCourseList().equals(courseList)){
            post.setCourseList(courseList.stream().map(course -> modelMapper.map(course, Course.class)).collect(Collectors.toList()));
        }
        if(!"".equals(context) && !post.getContext().equals(context)){
            post.setContext(context);
        }

        System.out.println(post);

        java.util.Date date = new Date();
        post.setPostDate(date);

        Post result = postRepository.save(post);

        return modelMapper.map(result, PostDTO.class);
    }

    @Transactional
    public Object deletePost(int postId){

        postRepository.deleteById(postId);

        return "null";
    }

    @Autowired
    private CourseRepository courseRepository;
    @Transactional
    public PostDTO registNewPostWithCourse(PostDTO postDTO) {

        List<CourseDTO> courseList = postDTO.getCourseList();

        postDTO.setCourseList(null);

        Post post = modelMapper.map(postDTO, Post.class);
        post.setPostDate(new Date());
        Post newPost = postRepository.save(post);

        for(CourseDTO courseDTO: courseList){
            courseDTO.setPostId(newPost.getPostId());
        }

        PostDTO result = modelMapper.map(post, PostDTO.class);

        result.setCourseList(courseList);

        return result;
    }

//    @Transactional
//    public PostDTO registNewPost(PostDTO newPost){
//
//        //저장하는 메소드 Repo.save()
//        Post result = postRepository.save(modelMapper.map(newPost, Post.class));
//
//        result.setPostDate(new java.util.Date());
//
//        return modelMapper.map(result, PostDTO.class);
//    }




}

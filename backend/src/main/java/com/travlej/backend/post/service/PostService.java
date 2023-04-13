package com.travlej.backend.post.service;

import com.travlej.backend.post.dto.PostDTO;
import com.travlej.backend.post.entity.Post;
import com.travlej.backend.post.repository.PostRepository;
import org.hibernate.id.enhanced.StandardOptimizerDescriptor;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
    public PostService(PostRepository postRepository, ModelMapper modelMapper) {
        this.postRepository = postRepository;
        this.modelMapper = modelMapper;
    }

    public List<PostDTO> findPostList(){

        List<Post> postList = postRepository.findAll();

        return postList.stream().map(post -> modelMapper.map(post, PostDTO.class)).collect(Collectors.toList());
    }

    public PostDTO findPostByPostId(int postId){

        Post post = postRepository.findById(postId).get();

        return modelMapper.map(post, PostDTO.class);
    }

    @Transactional
    public PostDTO registNewPost(PostDTO newPost){

//        log.info("[PostService] registNewPost Start ==========================");
//        log.info("[PostService] postDTO : " + newPost);

        //저장하는 메소드 Repo.save()
        Post result = postRepository.save(modelMapper.map(newPost, Post.class));

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
        String course = updatePost.getCourse();
        String context = updatePost.getContext();

        // update값이 비어있거나 기존과 같다면, 갱신하지 않는다.
        if(!"".equals(title) && !post.getPostTitle().equals(title)){
//            title = post.getPostTitle();
            post.setPostTitle(title);
        }
        if((null==start) || post.getPostStart().equals(start)) {
//            start = post.getPostStart();
            post.setPostStart(start);
        }
        if((null==end) || post.getPostEnd().equals(end)){
//            end = post.getPostEnd();
            post.setPostEnd(end);
        }
        if("".equals(course) || post.getCourse().equals(course)){
//            course = post.getCourse();
            post.setCourse(course);
        }
        if("".equals(context) || post.getContext().equals(context)){
//            context = post.getContext();
            post.setContext(context);
        }

        java.util.Date date = new Date();
        post.setPostDate(date);

//        Post result = postRepository.updatePost(
//                postId, date, title, start, end, course, context
//        );
        Post result = postRepository.save(post);

        return modelMapper.map(result, PostDTO.class);
    }

    @Transactional
    public Object deletePost(int postId){

        postRepository.deleteById(postId);

        return null;
    }


}

package com.travlej.backend.post.repository;

import com.travlej.backend.post.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Integer> {

    List<Post> findByPostTitleContaining(String postTitle);

    List<Post> findByWriterContainingAndPostDate(String writer, java.util.Date PostDate);

}

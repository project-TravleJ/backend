package com.travlej.backend.post.repository;

import com.travlej.backend.post.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Integer> {

    List<Post> findByPostTitleContaining(String postTitle);

    @Query(value="SELECT A.POST_ID, A.POST_TITLE, A.POST_DATE, A.WRITER, A.POST_START, A.POST_END, A.POST_CONTEXT, A.LIKES " +
            "FROM POST A " +
            "WHERE A.POST_TITLE LIKE :postTitle " +
            "ORDER BY POST_DATE DESC "
            , nativeQuery = true)
    List<Post> findByPostTitle(@Param("postTitle")String postTitle);

}

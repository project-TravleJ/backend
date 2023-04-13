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


    @Query(value="UPDATE POST A " +
            "SET A.POST_DATE = :date, A.POST_TITLE = :title, A.POST_START = :start, " +
            "A.POST_END = :end, A.COURSE = :course, A.POST_CONTEXT = :context " +
            "WHERE POST_ID LIKE :postId", nativeQuery = true)
    Post updatePost(
            @Param("postId") int postId,
            @Param("date") java.util.Date date,
            @Param("title") String title,
            @Param("start") java.util.Date start,
            @Param("end") java.util.Date end,
            @Param("course") String course,
            @Param("context") String context
    );
}

package com.travlej.backend.member.repository;

import com.beust.jcommander.internal.Nullable;
import com.travlej.backend.member.dto.MemberDTO;
import com.travlej.backend.member.entity.Member;
import com.travlej.backend.post.entity.Post;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
public interface MemberRepository extends JpaRepository<Member, Integer> {

    Optional<Member> findByMemberId(String memberId);

    @Query(value="SELECT A.MEMBER_CODE, A.MEMBER_NICKNAME, A.GRADE, A.STATUS, A.JOIN_DATE, A.LAST_ACCESS_DATE" +
            "FROM MEMBER A " +
            "WHERE A.MEMBER_NICKNAME LIKE :memberNickname " +
            "AND A.JOIN_DATE LIKE :joinDate" +
            "ANE A.LAST_ACCESS_DATE LIKE :lastAccessDate" +
            "ORDER BY A.MEMBER_CODE ASC "
            , nativeQuery = true)
    List<Member> findByMemberNickname(@Param("memberNickname")String memberNickname, @Param("joinDate")String joinDate, @Param("lastAccessDate")String lastAccessDate);

    List<Member> findByMemberNicknameContainingAndJoinDateIsContainingAndLastAccessDateIsContaining(String memberNickname, String joinDate, String lastAccessDate);

//    @Query(value = "SELECT A.MEMBER_CODE, A.MEMBER_ID, A.MEMBER_NICKNAME, A.MEMBER_PWD, A.STATUS, A.GRADE, A.JOIN_DATE, A.lAST_ACCESS_DATE FROM MEMBER A ORDER BY A.MEMBER_CODE ASC",
//            nativeQuery = true)

}

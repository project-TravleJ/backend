package com.travlej.backend.member.repository;

import com.travlej.backend.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
public interface MemberRepository extends JpaRepository<Member, Long> {

    Optional<Member> findByMemberNickname(String memberNickname);

    @Query(value="SELECT A.MEMBER_CODE, A.MEMBER_NICKNAME, A.GRADE, A.STATUS, A.JOIN_DATE, A.LAST_ACCESS_DATE" +
            "FROM MEMBER A " +
            "WHERE A.MEMBER_NICKNAME LIKE :memberNickname " +
            "AND A.JOIN_DATE LIKE :joinDate" +
            "ANE A.LAST_ACCESS_DATE LIKE :lastAccessDate" +
            "ORDER BY A.MEMBER_CODE ASC "
            , nativeQuery = true)
    List<Member> findByMemberNickname(@Param("memberNickname")String memberNickname, @Param("joinDate")String joinDate, @Param("lastAccessDate")String lastAccessDate);

    List<Member> findByMemberNicknameContainingAndStatusContainingAndGradeContainingAndJoinDateContainingAndLastAccessDateContaining(String memberNickname, String status, String grade, String joinDate, String lastAccessDate);

    @Query("SELECT m FROM Member AS m WHERE m.socialLogin LIKE :socialLogin AND m.socialId = :socialId")
    Member findBySocialId(String socialLogin, long socialId);

//    @Query(value = "SELECT A.MEMBER_CODE, A.MEMBER_ID, A.MEMBER_NICKNAME, A.MEMBER_PWD, A.STATUS, A.GRADE, A.JOIN_DATE, A.lAST_ACCESS_DATE FROM MEMBER A ORDER BY A.MEMBER_CODE ASC",
//            nativeQuery = true)

}

package com.travlej.backend.member.repository;

import com.travlej.backend.member.dto.MemberDTO;
import com.travlej.backend.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
public interface MemberRepository extends JpaRepository<Member, Integer> {
//    List<Member> findAllOrderByMemberCodeAsc(int memberCode);
    @Query(value = "SELECT A.MEMBER_CODE, A.MEMBER_ID, A.MEMBER_NICKNAME, A.MEMBER_PWD, A.STATUS, A.GRADE, A.JOIN_DATE, A.lAST_ACCESS_DATE FROM MEMBER A ORDER BY A.MEMBER_CODE ASC",
            nativeQuery = true)
    List<Member> findAllMember();

    Optional<Member> findByMemberId(String memberId);

    List<Member> findByMemberNicknameContaining(String memberNickname);

}

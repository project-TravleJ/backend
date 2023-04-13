//package com.travlej.backend.member.service;
//
//import com.travlej.backend.jwt.JwtProvider;
//import com.travlej.backend.member.dto.MemberDTO;
//import com.travlej.backend.member.dto.RequestDTO;
//import com.travlej.backend.member.entity.Authority;
//import com.travlej.backend.member.entity.Member;
//import com.travlej.backend.member.repository.MemberRepository;
//import lombok.RequiredArgsConstructor;
//import org.springframework.security.authentication.BadCredentialsException;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.Collections;
//
//@Service
//@RequiredArgsConstructor
//public class AuthService {
//
//    private final MemberRepository memberRepository;
//    private final PasswordEncoder passwordEncoder;
//    private final JwtProvider jwtProvider;
//
//    public MemberDTO login(RequestDTO request) {
//        Member member = memberRepository.findByMemberId(request.getMemberId()).orElseThrow(() ->
//                new BadCredentialsException("잘못된 계정 정보입니다."));
//
//        if (!passwordEncoder.matches(request.getMemberPwd(), member.getMemberPwd())) {
//            throw new BadCredentialsException("잘못된 계정 정보입니다.");
//        }
//
//        return MemberDTO.builder()
//                .memberCode(member.getMemberCode())
//                .memberId(member.getMemberId())
//                .memberNickname(member.getMemberNickname())
//                .status(member.getStatus())
//                .grade(member.getGrade())
//                .joinDate(member.getJoinDate())
//                .lastAccessDate(member.getLastAccessDate())
//                .roles(member.getRoles())
//                .token(jwtProvider.createToken(member.getMemberId(), member.getRoles()))
//                .build();
//
//    }
//
//    public boolean register(RequestDTO request) throws Exception {
//        try {
//            Member member = Member.builder()
//                    .memberId(request.getMemberId())
//                    .memberNickname(request.getMemberNickname())
//                    .memberPwd(request.getMemberPwd())
//                    .build();
//
//            member.setRoles(Collections.singletonList(Authority.builder().name("ROLE_USER").build()));
//
//            memberRepository.save(member);
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//            throw new Exception("잘못된 요청입니다.");
//        }
//        return true;
//    }
//
//    public MemberDTO getMember(String memberId) throws Exception {
//        Member member = memberRepository.findByMemberId(memberId)
//                .orElseThrow(() -> new Exception("계정을 찾을 수 없습니다."));
//        return new MemberDTO(member);
//    }
//}

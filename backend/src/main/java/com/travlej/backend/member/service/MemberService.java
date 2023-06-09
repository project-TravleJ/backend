package com.travlej.backend.member.service;


import com.travlej.backend.member.dto.MemberDTO;
import com.travlej.backend.member.entity.Member;
import com.travlej.backend.member.repository.MemberRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MemberService {

    private final MemberRepository memberRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public MemberService(MemberRepository memberRepository, ModelMapper modelMapper) {
        this.memberRepository = memberRepository;
        this.modelMapper = modelMapper;
    }

    public List<MemberDTO> findMemberList() {

        List<Member> memberList = memberRepository.findAll();

        return memberList.stream().map(member -> modelMapper.map(member, MemberDTO.class)).collect(Collectors.toList());
    }

    public MemberDTO findMemberByCode(Long memberCode) {

        Member member = memberRepository.findById(memberCode).get();

        return modelMapper.map(member, MemberDTO.class);
    }

    public List<MemberDTO> SearchByMultiple(MemberDTO memberDTO){

        List<Member> memberList = memberRepository.findByMemberNicknameContainingAndStatusContainingAndGradeContainingAndJoinDateContainingAndLastAccessDateContaining(memberDTO.getMemberNickname(), memberDTO.getStatus(), memberDTO.getGrade(), memberDTO.getJoinDate(), memberDTO.getLastAccessDate());

        return memberList.stream().map(member -> modelMapper.map(member, MemberDTO.class)).collect(Collectors.toList());
    }

    @Transactional
    public MemberDTO updateMember(Long memberCode, MemberDTO memberDTO) {

        Member member = memberRepository.findById(memberCode).get();

        String status = memberDTO.getStatus();
        String grade = memberDTO.getGrade();

        System.out.println("memberDTO: "+ memberDTO);
        System.out.println("Grade1: "+ grade);
        System.out.println("status: "+ status);

        if (status!=member.getStatus()) {
            member.setStatus(status);
        }
        if (!"".equals(grade) && !grade.equals(member.getGrade())) {
            member.setGrade(grade);
        }

        Member result = memberRepository.save(member);

        return modelMapper.map(result, MemberDTO.class);
    }

    public MemberDTO findBySocialId(String socialLogin, long socialId) {
        Member foundMember = memberRepository.findBySocialId(socialLogin, socialId);

        if (foundMember == null) {
            return null;
        } else {
            return modelMapper.map(foundMember, MemberDTO.class);
        }
    }

    @Transactional
    public long registNewUser(MemberDTO newMember) {

        newMember.setMemberNickname("새로운회원" + (Math.random() * 100 + 1));

        return memberRepository.save(modelMapper.map(newMember, Member.class)).getMemberCode();
    }
}
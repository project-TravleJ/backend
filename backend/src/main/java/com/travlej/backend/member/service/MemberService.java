package com.travlej.backend.member.service;


import com.travlej.backend.member.dto.MemberDTO;
import com.travlej.backend.member.dto.SearchDTO;
import com.travlej.backend.member.entity.Member;
import com.travlej.backend.member.repository.MemberMapper;
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
    private final MemberMapper memberMapper;

    @Autowired
    public MemberService(MemberRepository memberRepository, ModelMapper modelMapper, MemberMapper memberMapper) {
        this.memberRepository = memberRepository;
        this.modelMapper = modelMapper;
        this.memberMapper = memberMapper;
    }

    public List<MemberDTO> findMemberList() {

        List<Member> memberList = memberRepository.findAll();

        return memberList.stream().map(member -> modelMapper.map(member, MemberDTO.class)).collect(Collectors.toList());
    }

    public MemberDTO findMemberByCode(int memberCode) {

        Member member = memberRepository.findById(memberCode).get();

        return modelMapper.map(member, MemberDTO.class);
    }

    public List<MemberDTO> SearchByMultiple(MemberDTO memberDTO){

        List<Member> memberList = memberRepository.findByMemberNicknameContainingAndJoinDateIsContainingAndLastAccessDateIsContaining(memberDTO.getMemberNickname(), memberDTO.getJoinDate(), memberDTO.getLastAccessDate());

        return memberList.stream().map(member -> modelMapper.map(member, MemberDTO.class)).collect(Collectors.toList());
    }

    @Transactional
    public MemberDTO updateMember(int memberCode, MemberDTO memberDTO) {

        Member member = memberRepository.findById(memberCode).get();

        int status = memberDTO.getStatus();
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


    public List<SearchDTO> selectMemberByMultiple(SearchDTO searchDTO) {
        return memberMapper.selectMemberByMultiple(searchDTO);
    }

//    @Transactional
//    public MemberDTO updatePwd(int memberCode, MemberDTO memberDTO) {
//        Member member = memberRepository.findById(memberCode).get();
//
//        String memberPwd = memberDTO.getMemberPwd();
//
//        if (!"".equals(memberPwd) && memberPwd.equals(member.getMemberPwd()))
//    }
}
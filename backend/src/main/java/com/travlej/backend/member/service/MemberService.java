package com.travlej.backend.member.service;

import com.travlej.backend.member.dto.MemberDTO;
import com.travlej.backend.member.entity.Member;
import com.travlej.backend.member.repository.MemberRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {

    private final MemberRepository memberRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public MemberService(MemberRepository memberRepository, ModelMapper modelMapper) {
        this.memberRepository = memberRepository;
        this.modelMapper = modelMapper;
    }

    public MemberDTO findMemberByCode(int memberCode) {

     Member member = memberRepository.findById(memberCode).get();

     return modelMapper.map(member, MemberDTO.class);
    }

//    public MemberDTO findMemberList() {
//
//    }
}

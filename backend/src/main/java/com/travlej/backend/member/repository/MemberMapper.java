package com.travlej.backend.member.repository;

import com.travlej.backend.member.dto.SearchDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MemberMapper {

    List<SearchDTO> selectMemberByMultiple(SearchDTO searchDTO);
}

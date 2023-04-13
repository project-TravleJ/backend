package com.travlej.backend.member.service;

import com.travlej.backend.member.entity.CustomUserDetails;
import com.travlej.backend.member.entity.Member;
import com.travlej.backend.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final MemberRepository memberRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Member member = memberRepository.findByMemberId(username).orElseThrow(
                () -> new UsernameNotFoundException("Invalid authentication!")
        );
        
        return new CustomUserDetails(member);
    }
}

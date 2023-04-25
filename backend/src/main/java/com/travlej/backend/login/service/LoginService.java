package com.travlej.backend.login.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.travlej.backend.jwt.TokenProvider;
import com.travlej.backend.login.dto.AccessTokenDTO;
import com.travlej.backend.login.dto.KakaoProfileDTO;
import com.travlej.backend.login.dto.OauthTokenDTO;
import com.travlej.backend.login.dto.RenewTokenDTO;
import com.travlej.backend.login.repository.LoginRepository;
import com.travlej.backend.member.dto.MemberDTO;
import com.travlej.backend.member.service.MemberService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.Date;

@Service
public class LoginService {

    private final LoginRepository loginRepository;
    private final ModelMapper modelMapper;
    private final MemberService memberService;
    private final TokenProvider tokenProvider;

    @Autowired
    public LoginService(LoginRepository loginRepository, ModelMapper modelMapper, MemberService memberService, TokenProvider tokenProvider) {
        this.loginRepository = loginRepository;
        this.modelMapper = modelMapper;
        this.memberService = memberService;
        this.tokenProvider = tokenProvider;
    }

    public OauthTokenDTO getAccessToken(String code) {

        RestTemplate rt = new RestTemplate();
        rt.setRequestFactory(new HttpComponentsClientHttpRequestFactory());

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-type", "application/x-www-form-urlencoded;charset=utf-8");

        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("grant_type", "authorization_code");
        params.add("client_id", "33675c8bccf3c9affdd25308b1d5454a");
        params.add("redirect_uri", "http://localhost:3000/oauth");
        params.add("code", code);

        HttpEntity<MultiValueMap<String, String>> kakaoTokenRequest =
                new HttpEntity<>(params, headers);

        ResponseEntity<String> accessTokenResponse = rt.exchange(
                "https://kauth.kakao.com/oauth/token",
                HttpMethod.POST,
                kakaoTokenRequest,
                String.class
        );

        System.out.println(accessTokenResponse);
        System.out.println(accessTokenResponse.getHeaders());
        System.out.println(accessTokenResponse.getBody());

        ObjectMapper objectMapper = new ObjectMapper();
        OauthTokenDTO oauthToken = null;
        try {
            oauthToken = objectMapper.readValue(accessTokenResponse.getBody(), OauthTokenDTO.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return oauthToken;
    }

    public KakaoProfileDTO findKakaoProfile(String accessToken) {
        RestTemplate rt = new RestTemplate();
		rt.setRequestFactory(new HttpComponentsClientHttpRequestFactory());

        System.out.println("testtttttttttttttttttttttttttttttttttt");

        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Bearer " + accessToken);
        headers.add("Content-type", "application/x-www-form-urlencoded;charset=utf-8");

        HttpEntity<MultiValueMap<String, String>> kakaoProfileRequest =
                new HttpEntity<>(headers);

        ResponseEntity<String> kakaoProfileResponse = rt.exchange(
                "https://kapi.kakao.com/v2/user/me",
                HttpMethod.POST,
                kakaoProfileRequest,
                String.class
        );

        System.out.println("kakaoProfileResponse : " + kakaoProfileResponse.getBody());

        KakaoProfileDTO kakaoProfileDTO = new KakaoProfileDTO();
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            kakaoProfileDTO = objectMapper.readValue(kakaoProfileResponse.getBody(),
                    KakaoProfileDTO.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        return kakaoProfileDTO;
    }

    public AccessTokenDTO getJwtToken(OauthTokenDTO oauthToken) {

        KakaoProfileDTO kakaoProfileDTO = findKakaoProfile(oauthToken.getAccess_token());

        MemberDTO foundmember = new MemberDTO();

        // 해당 유저의 가입 이력이 없을 경우
        if (memberService.findBySocialId("KAKAO", kakaoProfileDTO.getId()) == null) {

            MemberDTO newMember = new MemberDTO();

            newMember.setSocialLogin("KAKAO");
            newMember.setSocialId(kakaoProfileDTO.getId());
            newMember.setEmail(kakaoProfileDTO.getKakao_account().getEmail());
            newMember.setRefreshToken(oauthToken.getRefresh_token());
            newMember.setAccessToken(oauthToken.getAccess_token());
            newMember.setSignUpDate(LocalDateTime.now());
            newMember.setRefreshTokenExpireDate(oauthToken.getRefresh_token_expires_in() + System.currentTimeMillis());
            newMember.setAccessTokenExpireDate(oauthToken.getExpires_in() + System.currentTimeMillis());
            newMember.setImageSource("https://api.dicebear.com/6.x/thumbs/svg?seed=" + newMember.getEmail().split("@")[0]);

//            if (kakaoProfileDTO.getKakao_account().getGender() != null) {
//                newMember.setGender(kakaoProfileDTO.getKakao_account().getGender());
//            }

            memberService.registNewUser(newMember);
        }

        foundmember = memberService.findBySocialId("KAKAO", kakaoProfileDTO.getId());

        Date accessExpireDate = new Date(foundmember.getAccessTokenExpireDate());

        if (accessExpireDate.before(new Date())) {
            RenewTokenDTO renewedToken = renewKakaoToken(foundmember);

            if(renewedToken.getRefresh_token() != null) {

                foundmember.setRefreshToken(renewedToken.getRefresh_token());
                foundmember.setRefreshTokenExpireDate(renewedToken.getRefresh_token_expires_in());
            }

            foundmember.setAccessToken(renewedToken.getAccess_token());
            foundmember.setAccessTokenExpireDate(renewedToken.getExpires_in() + System.currentTimeMillis());
        }

        return tokenProvider.generateMemberTokenDTO(foundmember);
    }

    private RenewTokenDTO renewKakaoToken(MemberDTO foundmember) {

        RestTemplate rt = new RestTemplate();
        rt.setRequestFactory(new HttpComponentsClientHttpRequestFactory());

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-type", "application/x-www-form-urlencoded;charset=utf-8");

        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("grant_type", "refresh_token");
        params.add("client_id", "33675c8bccf3c9affdd25308b1d5454a");
        params.add("refresh_token", foundmember.getRefreshToken());

        System.out.println("refresh" + foundmember.getRefreshToken());

        HttpEntity<MultiValueMap<String, String>> kakaoTokenRequest =
                new HttpEntity<>(params, headers);

        ResponseEntity<String> renewTokenResponse = rt.exchange(
                "https://kauth.kakao.com/oauth/token",
                HttpMethod.POST,
                kakaoTokenRequest,
                String.class
        );

        ObjectMapper objectMapper = new ObjectMapper();
        RenewTokenDTO renewToken = null;
        try {
            renewToken = objectMapper.readValue(renewTokenResponse.getBody(), RenewTokenDTO.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return renewToken;
    }
}

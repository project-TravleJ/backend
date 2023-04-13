//package com.travlej.backend.jwt;
//
//import com.travlej.backend.member.entity.Authority;
//import com.travlej.backend.member.service.CustomUserDetailsService;
//import io.jsonwebtoken.*;
//import io.jsonwebtoken.security.Keys;
//import lombok.RequiredArgsConstructor;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.stereotype.Component;
//
//import javax.annotation.PostConstruct;
//import javax.servlet.http.HttpServletRequest;
//import java.nio.charset.StandardCharsets;
//import java.security.Key;
//import java.util.Date;
//import java.util.List;
//
//@RequiredArgsConstructor
//@Component
//public class JwtProvider {
//
//    @Value("${jwt.secret.key}")
//    private String salt;
//
//    private Key jwtsecretKey;
//
//    // 만료 시간 : 30분
//    private final long exp = 1000L * 60 * 30;
//
//    private final CustomUserDetailsService customUserDetailsService;
//
//    @PostConstruct
//    protected void init() {
//        jwtsecretKey = Keys.hmacShaKeyFor(salt.getBytes(StandardCharsets.UTF_8));
//    }
//
//    // 토큰 생성
//    public String createToken(String memberId, List<Authority> roles) {
//        Claims claims = Jwts.claims().setSubject(memberId);
//        claims.put("roles", roles);
//        Date now = new Date();
//        return Jwts.builder()
//                .setClaims(claims)
//                .setIssuedAt(now)
//                .setExpiration(new Date(now.getTime() + exp))
//                .signWith(jwtsecretKey, SignatureAlgorithm.ES512)
//                .compact();
//    }
//
//    // 권한정보 획득
//    // Spring Security 인증과정에서 권한확인을 위한 기능
//    public Authentication getAuthentication(String token) {
//        UserDetails userDetails = customUserDetailsService.loadUserByUsername(this.getMemberId(token));
//        return new UsernamePasswordAuthenticationToken(userDetails, "", userDetails.getAuthorities());
//    }
//
//    // 토큰에 담겨있는 회원 id 획득
//    public String getMemberId(String token) {
//        return Jwts.parserBuilder().setSigningKey(jwtsecretKey).build().parseClaimsJwt(token).getBody().getSubject();
//    }
//
//    // Authorization Header를 통해 인증을 한다.
//    public String resolveToken(HttpServletRequest request) {
//        return request.getHeader("Authorization");
//    }
//
//    // 토큰 검증
//    public boolean validateToken(String token) {
//        try {
//            // Bearer 검증
//            if (!token.substring(0, "BEARER".length()).equalsIgnoreCase("BEARER")) {
//                return false;
//            } else {
//                token = token.split(" ")[1].trim();
//            }
//            Jwt<Header, Claims> claims = Jwts.parserBuilder().setSigningKey(jwtsecretKey).build().parseClaimsJwt(token);
//            // 만료되었을 시 false
//            return !claims.getBody().getExpiration().before(new Date());
//        } catch (Exception e) {
//            return false;
//        }
//    }
//
//}

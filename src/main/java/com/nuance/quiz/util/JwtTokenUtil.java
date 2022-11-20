package com.nuance.quiz.util;

import com.nuance.quiz.entity.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class JwtTokenUtil {
    private final String SECRET_KEY = "secret";

    public String extractUserName(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    public Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    public String generateToken(User userDetails) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("email", userDetails.getEmail());
        claims.put("fname", userDetails.getFname());
        claims.put("lname", userDetails.getLname());
        return createToken(claims, String.valueOf(userDetails.getUserId()), new Date(System.currentTimeMillis() + 100 * 60 * 60 * 10));
    }

//    public String generateRefreshToken(AuthenticationRequest userDetails) {
//        Map<String, Object> claims = new HashMap<>();
//        claims.put("type","refresh");
//        return createToken(claims, userDetails.getId(), new Date(System.currentTimeMillis() + 10 * 24 * 100 * 60 * 60 * 10));
//    }
//
    public Boolean validate(String token) {
        final String username = extractUserName(token);
        return !isTokenExpired(token);
    }

    private <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    private Claims extractAllClaims(String token) {
        return Jwts.parser()
                .setSigningKey(SECRET_KEY)
                .parseClaimsJws(token)
                .getBody();
    }

    private Boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    private String createToken(Map<String, Object> claims, String subject, Date expiration) {
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(subject)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(expiration)
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                .compact();
    }
}

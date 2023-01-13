package com.merca.project.mercaproject.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class TokenUtils {

    private final static String ACCESS_TOKEN_SECRET = "1b07c25b32d45b6babf2834c6f934093";
    private final static Long ACCESS_TOKEN_VALIDITY_SECONDS = 200000L;

    public static String createToken(String name, String email){
        long expirationTokenTime = ACCESS_TOKEN_VALIDITY_SECONDS * 1000;
        Date expirationTokenDate = new Date(System.currentTimeMillis() + expirationTokenTime);
        Map<String, Object> charactersExtra = new HashMap<>();
        charactersExtra.put("name", name);

        return Jwts.builder()
                .setSubject(email)
                .setExpiration(expirationTokenDate)
                .addClaims(charactersExtra)
                .signWith(Keys.hmacShaKeyFor(ACCESS_TOKEN_SECRET.getBytes()))
                .compact();
    }

    public static UsernamePasswordAuthenticationToken getAuthentication(String token){
        try{
            Claims claims = Jwts.parserBuilder()
                    .setSigningKey(ACCESS_TOKEN_SECRET.getBytes())
                    .build()
                    .parseClaimsJws(token)
                    .getBody();

            String email = claims.getSubject();

            return new UsernamePasswordAuthenticationToken(email, null, Collections.emptyList());
        }catch (JwtException e){
            return null;

        }
    }

}

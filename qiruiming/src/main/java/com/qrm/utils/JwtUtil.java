package com.qrm.utils;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

public class JwtUtil {

    public static final String KEY="qrm123";

    public static String create(String username) {
        Date now = new Date();
        return Jwts.builder()
                .signWith(SignatureAlgorithm.HS256, KEY)
                .setIssuedAt(now)   // 签发时间
                .setExpiration(new Date(now.getTime() + 1000 * 60 * 10)) // 过期时间
                .setSubject(username)
                .compact();
    }

    public static String getUsername(String jwt) {
        return Jwts.parser()
                .setSigningKey(KEY).parseClaimsJws(jwt).getBody()
                .getSubject();
    }
}

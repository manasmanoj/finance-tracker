package com.ustg.FTWA.config;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import ch.qos.logback.classic.Logger;

import java.security.Key;
import java.util.Date;

@Component
public class JwtUtil {
    private static final Logger logger = (Logger) LoggerFactory.getLogger(JwtUtil.class);

    private final Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256); // or use your own SECRET_KEY

    public String generateToken(String username) {
        try {
            String token = Jwts.builder()
                    .setSubject(username)
                    .setIssuedAt(new Date())
                    .setExpiration(new Date(System.currentTimeMillis() + 86400000)) // 1 day expiration
                    .signWith(key)
                    .compact();

            // Log the token generation process for debugging
            logger.info("Generated token: " + token);
            return token;
        } catch (Exception e) {
            logger.error("Error while generating JWT: ", e);
            return null;
        }

    }

    public String extractUsername(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token);
            return true;
        } catch (JwtException e) {
            return false;
        }
    }
}

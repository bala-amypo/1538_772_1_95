package com.example.demo.security;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.Authentication;

import javax.crypto.SecretKey;
import java.util.Date;

public class JwtTokenProvider {

    private final SecretKey secretKey;
    private final long validityInMs;

    // ✅ REQUIRED constructor signature
    public JwtTokenProvider(String secret, long validityInMs) {
        // 🔥 THIS FIXES WeakKeyException
        this.secretKey = Keys.hmacShaKeyFor(secret.getBytes());
        this.validityInMs = validityInMs;
    }

    // =====================================================
    // Generate JWT
    // =====================================================
    public String generateToken(Authentication authentication,
                                Long userId,
                                String email,
                                String role) {

        Claims claims = Jwts.claims();
        claims.put("userId", userId);
        claims.put("email", email);
        claims.put("role", role); // DO NOT prefix ROLE_

        Date now = new Date();
        Date expiry = new Date(now.getTime() + validityInMs);

        return Jwts.builder()
                .setClaims(claims)
                .setSubject(String.valueOf(userId)) // fallback subject
                .setIssuedAt(now)
                .setExpiration(expiry)
                .signWith(secretKey, SignatureAlgorithm.HS256)
                .compact();
    }

    // =====================================================
    // Validate JWT
    // =====================================================
    public boolean validateToken(String token) {
        try {
            Jwts.parserBuilder()
                    .setSigningKey(secretKey)
                    .build()
                    .parseClaimsJws(token);
            return true;
        } catch (JwtException | IllegalArgumentException e) {
            return false;
        }
    }

    // =====================================================
    // Extract User ID
    // =====================================================
    public Long getUserIdFromToken(String token) {
        Claims claims = Jwts.parserBuilder()
                .setSigningKey(secretKey)
                .build()
                .parseClaimsJws(token)
                .getBody();

        Object userId = claims.get("userId");

        if (userId != null) {
            return Long.parseLong(userId.toString());
        }

        // 🔁 fallback to subject
        return Long.parseLong(claims.getSubject());
    }

    // =====================================================
    // Extract Email
    // =====================================================
    public String getEmailFromToken(String token) {
        Claims claims = Jwts.parserBuilder()
                .setSigningKey(secretKey)
                .build()
                .parseClaimsJws(token)
                .getBody();

        return claims.get("email", String.class);
    }

    // =====================================================
    // Extract Role (NO PREFIX CHANGE)
    // =====================================================
    public String getRoleFromToken(String token) {
        Claims claims = Jwts.parserBuilder()
                .setSigningKey(secretKey)
                .build()
                .parseClaimsJws(token)
                .getBody();

        return claims.get("role", String.class);
    }
}

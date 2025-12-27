package com.example.demo.security;

import io.jsonwebtoken.*;
import org.springframework.security.core.Authentication;

import java.util.Date;

public class JwtTokenProvider {

    private final String secret;
    private final long validityMs;

    public JwtTokenProvider(String secret, long validityMs) {
        this.secret = secret;
        this.validityMs = validityMs;
    }

    public String generateToken(Authentication auth,
                                Long userId,
                                String email,
                                String role) {
        Claims claims = Jwts.claims().setSubject(userId.toString());
        claims.put("email", email);
        claims.put("role", role);

        Date now = new Date();
        Date exp = new Date(now.getTime() + validityMs);

        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(now)
                .setExpiration(exp)
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parser().setSigningKey(secret).parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Long getUserIdFromToken(String token) {
        return Long.parseLong(
                Jwts.parser().setSigningKey(secret)
                        .parseClaimsJws(token)
                        .getBody().getSubject());
    }

    public String getEmailFromToken(String token) {
        return (String) Jwts.parser().setSigningKey(secret)
                .parseClaimsJws(token)
                .getBody().get("email");
    }

    public String getRoleFromToken(String token) {
        return (String) Jwts.parser().setSigningKey(secret)
                .parseClaimsJws(token)
                .getBody().get("role");
    }
}

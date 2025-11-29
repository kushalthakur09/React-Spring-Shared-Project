package com.example.backend.auth.service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

public class JwtService {
	// Secret key BASE64 encoded (example key)
    private String secretKey = "483F4528482B4D6251655468576D5A7134743777217A25432A462D4A614E6452";
	public String generateToken(String username) {
		Map<String, Object> map = new HashMap<>();
		return Jwts.builder()
		.setClaims(map)
		.setSubject(username)
		.setIssuedAt(new Date(System.currentTimeMillis()))
		.setExpiration(new Date(System.currentTimeMillis()+1000*60*60*3))
		.signWith(getKey(),SignatureAlgorithm.HS256)
		.compact();
	}
	public Key getKey() {
		byte[] keyBytes = Decoders.BASE64.decode(secretKey);
        return Keys.hmacShaKeyFor(keyBytes);
	}
}

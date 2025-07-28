package com.auth.utils;

import java.security.Key;
import java.util.Base64.Decoder;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtUtils 
{
	public static final String secret ="bc02004a807cfc3578b826f800e467d526422cf55b8061f14048ace37f5c939c";

	public String generateToken(String userName)
	{
		Map<String,Object> claims = new HashMap<>();
		return createToken(claims,userName);
		
	}
	
	public String createToken(Map<String,Object> claims, String userName)
	{
		return Jwts.builder()
		.setClaims(claims)
		.setSubject(userName)
		.setIssuedAt(new Date(System.currentTimeMillis()))
		.setExpiration(new Date(System.currentTimeMillis()+1000*60*30))
		.signWith(getSignKey(), SignatureAlgorithm.HS256).compact();
	}
	
	private Key getSignKey()
	{
		byte[] key = Decoders.BASE64.decode(secret);
		return Keys.hmacShaKeyFor(key);
		
	}
	
	
	public String validateToken(String token)
	{
		Jwts.parserBuilder().setSigningKey(getSignKey()).build().parseClaimsJws(token);
		return "valid token";
	}
}

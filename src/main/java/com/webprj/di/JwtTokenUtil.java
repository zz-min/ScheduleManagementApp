package com.webprj.di;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class JwtTokenUtil {
	private static final String SECRET_KEY = "PRIVATE_KEY"; // Key는 하드코딩 하지말고 외부에서 가져오는것을 권장

	public static String createToken(String subject, AccessVO accessVO, Boolean hasPermission, Errors errors) {

		long ttlMillis = (10 * 1000 * 60);

		if (ttlMillis <= 0) {
			throw new RuntimeException("Expiry time must be greater than Zero : [" + ttlMillis + "] ");
		}
		SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;

		byte[] secretKeyBytes = DatatypeConverter.parseBase64Binary(SECRET_KEY);
		Key signingKey = new SecretKeySpec(secretKeyBytes, signatureAlgorithm.getJcaName());
		JwtBuilder builder = Jwts.builder().setSubject(subject).setIssuer("leafcats.com").setHeaderParam("typ", "JWT")
				.claim("hasPermission", hasPermission).signWith(signatureAlgorithm, signingKey);

		Map<String, Object> map = new HashMap<String, Object>();

		// private claim으로 VO객체를 추가할 수 있음
		if (accessVO != null) {
			builder.claim("access", accessVO);
		}

		if (errors != null) {
			builder.claim("errors", errors);
		}

		long nowMillis = System.currentTimeMillis();
		builder.setExpiration(new Date(nowMillis + ttlMillis));
		return builder.compact();
	}

	public static String getSubject(String token) {
		Claims claims = Jwts.parser().setSigningKey(DatatypeConverter.parseBase64Binary(SECRET_KEY))
				.parseClaimsJws(token).getBody();
		return claims.getSubject();
	}

	public static Claims getTokenData(String token) {
		Claims claims = Jwts.parser().setSigningKey(DatatypeConverter.parseBase64Binary(SECRET_KEY))
				.parseClaimsJws(token).getBody();
		return claims;
	}

	public static Map<String, Object> getSubjectMap(String token) {

		String subject = getSubject(token);
		Map<String, Object> map = new LinkedHashMap<String, Object>();
		map.put("result", subject);
		return map;
	}
}

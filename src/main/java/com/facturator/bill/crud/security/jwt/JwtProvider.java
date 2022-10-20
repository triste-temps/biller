package com.facturator.bill.crud.security.jwt;

import java.security.Key;
import java.util.Base64;
import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import com.facturator.bill.crud.security.utils.UserPrincipal;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.UnsupportedJwtException;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.security.SignatureException;

@Component
public class JwtProvider {
	@Value("${app.jwtSecretKey}")
	private String secret;

	@Value("${app.jwtExpirationInMs}")
	private int jwtExpirationInMs;

	private Key key;

	protected final Log logger = LogFactory.getLog(getClass());

	private Key getSigningKey() {
		if (key == null) {
			byte[] keyBytes = Base64.getUrlDecoder().decode(this.secret);
			key = Keys.hmacShaKeyFor(keyBytes);
		}
		return key;
	}

	// on génère le token avec le username, la clé de sécurité et la date
	// d'expiration
	public String generateToken(Authentication authentication) {
		UserPrincipal userPrincipal = (UserPrincipal) authentication.getPrincipal();
		Date now = new Date();
		Date expiryDate = new Date(now.getTime() + jwtExpirationInMs);
		// on fait appel à l'interface JJWT
		return Jwts.builder().setSubject(userPrincipal.getUsername()).setIssuedAt(new Date()).setExpiration(expiryDate)
				.signWith(getSigningKey(), SignatureAlgorithm.HS512).compact();
	}

	public String getUserUsernameFromJWT(String token) {
		Claims claims = Jwts.parserBuilder().setSigningKey(getSigningKey()).build().parseClaimsJws(token).getBody();
		return claims.getSubject();
	}

	public boolean validateToken(String authToken) {
		try {
			Jwts.parserBuilder().setSigningKey(getSigningKey()).build().parseClaimsJws(authToken);
			return true;
		} catch (SignatureException ex) {
		} catch (MalformedJwtException ex) {
		} catch (ExpiredJwtException ex) {
		} catch (UnsupportedJwtException ex) {
		} catch (IllegalArgumentException ex) {
		}
		return false;
	}
}

package com.guedes.todo_plus_backend.infra.secutiry;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.function.Function;

//@Service
public class TokenService {

  @Value("${api.security.token.secret}")
  private String securityKey;

  @Value("${security.jwt.expiration-time}")
  private long jwtExpiration;

  public long getExpirationTime() {
    return jwtExpiration;
  }

  private Key getSignInKey() {
    byte[] keyBytes = Decoders.BASE64.decode(securityKey);
    return Keys.hmacShaKeyFor(keyBytes);
  }

  private Claims extractAllClains(String token) {
    return Jwts
            .parserBuilder()
            .setSigningKey(this.getSignInKey())
            .build()
            .parseClaimsJws(token)
            .getBody();
  }

  private String buildToken(HashMap<String, Object> extraClaims, UserDetails userDetails, Long expiriton) {
    return Jwts
            .builder()
            .setClaims(extraClaims)
            .setSubject(userDetails.getUsername())
            .setIssuedAt(new Date(System.currentTimeMillis()))
            .setExpiration(new Date(System.currentTimeMillis() + expiriton))
            .signWith(getSignInKey(), SignatureAlgorithm.ES256)
            .compact();
  }

  public String generateToken(HashMap<String, Object> extraClaims, UserDetails userDetails) {
    return buildToken(extraClaims, userDetails, jwtExpiration);
  }

  public String generateToken(UserDetails userDetails) {
    return  generateToken(new HashMap<>(), userDetails);
  }

  public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
    final Claims claims = extractAllClains(token);
    return claimsResolver.apply(claims);
  }

  public String extractUsername(String token) {
    String email;
    email = extractClaim(token, Claims::getSubject);
    return email;
  }

  private Date extractExpiration(String token) {
    return extractClaim(token, Claims::getExpiration);
  }

  private boolean isTokenExpired(String token) {
    return extractExpiration(token).before(new Date());
  }

  public boolean isTokenValid(String token, UserDetails userDetails) {
    final String username = extractUsername(token);
    return (username.equals(userDetails.getUsername())) && !isTokenExpired(token);
  }

}
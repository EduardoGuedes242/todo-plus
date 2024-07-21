package com.guedes.todo_plus_backend.infra.secutiry;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class TokenService {

  @Value("${api.security.token.secret}")
  private String securityKey;

  @Value("${security.jwt.expiration-time}")
  private long jwtExpiration;


}
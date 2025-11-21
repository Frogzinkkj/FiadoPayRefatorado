package com.example.FiadoPayRefatorado.api.dto.auth;

import java.time.LocalDateTime;

public class AuthResponseDTO {
  private String token;
  private LocalDateTime expiresAt;

  public AuthResponseDTO(String token, LocalDateTime expiresAt) {
    this.token = token;
    this.expiresAt = expiresAt;
  }

  public String getToken() {
    return token;
  }

  public void setToken(String token) {
    this.token = token;
  }

  public LocalDateTime getExpiresAt() {
    return expiresAt;
  }

  public void setExpiresAt(LocalDateTime expiresAt) {
    this.expiresAt = expiresAt;
  }
}

package com.example.FiadoPayRefatorado.domain.exception;

public class AuthCheckException extends RuntimeException {
  public AuthCheckException(String message) {
    super(message);
  }
}

package com.example.FiadoPayRefatorado.domain.exception;

public class PaymentException extends RuntimeException {
  public PaymentException(String message) {
    super(message);
  }
}

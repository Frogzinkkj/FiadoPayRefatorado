package com.example.FiadoPayRefatorado.domain.contracts;

import com.example.FiadoPayRefatorado.domain.model.Payment;

public interface PaymentProcessor {
  public void process(Payment payment);
}

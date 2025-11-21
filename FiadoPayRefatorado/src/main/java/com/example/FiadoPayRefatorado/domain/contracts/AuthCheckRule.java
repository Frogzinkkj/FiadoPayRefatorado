package com.example.FiadoPayRefatorado.domain.contracts;


import com.example.FiadoPayRefatorado.annotations.AuthCheck;
import com.example.FiadoPayRefatorado.domain.exception.AuthCheckException;
import com.example.FiadoPayRefatorado.domain.model.Payment;

public interface AuthCheckRule {
  public void validate(Payment payment) throws AuthCheckException;
}

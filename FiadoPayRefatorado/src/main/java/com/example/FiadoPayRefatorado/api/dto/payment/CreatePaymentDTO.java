package com.example.FiadoPayRefatorado.api.dto.payment;

import java.math.BigDecimal;

public class CreatePaymentDTO {
  private BigDecimal amount;
  private String method;
  private int installments;
  private String customerReference;


  public CreatePaymentDTO(BigDecimal amount, String method, int installments, String customerReference) {
    this.amount = amount;
    this.method = method;
    this.installments = installments;
    this.customerReference = customerReference;
  }

  public BigDecimal getAmount() {
    return amount;
  }

  public void setAmount(BigDecimal amount) {
    this.amount = amount;
  }

  public String getMethod() {
    return method;
  }

  public String getCustomerReference() {
    return customerReference;
  }

  public void setCustomerReference(String customerReference) {
    this.customerReference = customerReference;
  }

  public void setMethod(String method) {
    this.method = method;
  }

  public int getInstallments() {
    return installments;
  }

  public void setInstallments(int installments) {
    this.installments = installments;
  }
}

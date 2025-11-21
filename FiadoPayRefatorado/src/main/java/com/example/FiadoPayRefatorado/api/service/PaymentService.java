package com.example.FiadoPayRefatorado.api.service;

import com.example.FiadoPayRefatorado.domain.contracts.PaymentProcessor;
import com.example.FiadoPayRefatorado.domain.enums.PaymentMethodType;
import com.example.FiadoPayRefatorado.domain.model.Payment;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class PaymentService {
  private final PaymentProcessor paymentProcessor;

  public PaymentService(PaymentProcessor paymentProcessor) {
    this.paymentProcessor = paymentProcessor;
  }

  public Payment createPayment(Payment payment){
    if (payment.getPaymentMethodType()== PaymentMethodType.CARD && payment.getInstallments()>1){
      BigDecimal taxForMouth = new BigDecimal("0.01");
      BigDecimal totalTax = taxForMouth.multiply(BigDecimal.valueOf(payment.getInstallments()));
      BigDecimal fator = BigDecimal.ONE.add(totalTax);
      BigDecimal amountWithTax = payment.getAmount().multiply(fator);
      payment.setAmount(amountWithTax);
    }
    paymentProcessor.process(payment);
    return payment;
  }

}

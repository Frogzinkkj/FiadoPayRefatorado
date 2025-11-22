package com.example.FiadoPayRefatorado.api.service;

import com.example.FiadoPayRefatorado.domain.contracts.PaymentProcessor;
import com.example.FiadoPayRefatorado.domain.enums.PaymentMethodType;
import com.example.FiadoPayRefatorado.domain.model.Payment;
import com.example.FiadoPayRefatorado.repository.PaymentRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.UUID;

@Service
public class PaymentService {
    private final PaymentProcessor paymentProcessor;
    private final PaymentRepository paymentRepository;

    public PaymentService(PaymentProcessor paymentProcessor,
                          PaymentRepository paymentRepository) {
        this.paymentProcessor = paymentProcessor;
        this.paymentRepository = paymentRepository;
    }

    public Payment createPayment(Payment payment) {

        if (payment.getIdempotencyKey() != null) {
            Optional<Payment> existing =
                    paymentRepository.findByIdempotencyKey(payment.getIdempotencyKey());
            if (existing.isPresent()) {
                return existing.get();
            }
        }


        if (payment.getPaymentMethodType() == PaymentMethodType.CARD &&
                payment.getInstallments() > 1) {
            BigDecimal taxForMouth = new BigDecimal("0.01");
            BigDecimal totalTax =
                    taxForMouth.multiply(BigDecimal.valueOf(payment.getInstallments()));
            BigDecimal fator = BigDecimal.ONE.add(totalTax);
            BigDecimal amountWithTax = payment.getAmount().multiply(fator);
            payment.setAmount(amountWithTax);
        }


        Payment savedPayment = paymentRepository.save(payment);


        paymentProcessor.process(savedPayment);

        return savedPayment;
    }

    public Optional<Payment> getPaymentById(UUID id) {
        return paymentRepository.findById(id);
    }
}

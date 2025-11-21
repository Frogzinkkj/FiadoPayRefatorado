package com.example.FiadoPayRefatorado.infrastructure.processor;

import com.example.FiadoPayRefatorado.domain.enums.PaymentStatus;
import com.example.FiadoPayRefatorado.domain.model.Payment;
import com.example.FiadoPayRefatorado.repository.PaymentRepository;

import java.util.Random;

public class PaymentWorker implements Runnable {

    private final Payment payment;
    private final PaymentRepository repository;

    public PaymentWorker(Payment payment, PaymentRepository repository) {
        this.payment = payment;
        this.repository = repository;
    }

    @Override
    public void run() {
        try {
            payment.setPaymentStatus(PaymentStatus.PROCESSING);
            repository.save(payment);

            Thread.sleep(2000);

            Random random = new Random();
            if (random.nextInt(100) < 80) {
                payment.setPaymentStatus(PaymentStatus.APPROVED);
            } else {
                payment.setPaymentStatus(PaymentStatus.DECLINED);
            }

            repository.save(payment);

        } catch (Exception e) {
            payment.setPaymentStatus(PaymentStatus.FAILED);
            repository.save(payment);
        }
    }
}
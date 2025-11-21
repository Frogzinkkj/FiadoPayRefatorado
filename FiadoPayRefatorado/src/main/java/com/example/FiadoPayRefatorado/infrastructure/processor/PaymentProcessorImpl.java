package com.example.FiadoPayRefatorado.infrastructure.processor;

import com.example.FiadoPayRefatorado.domain.contracts.PaymentProcessor;
import com.example.FiadoPayRefatorado.domain.model.Payment;
import com.example.FiadoPayRefatorado.repository.PaymentRepository;
import org.springframework.stereotype.Component;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Component
public class PaymentProcessorImpl implements PaymentProcessor {

    private final ExecutorService executor;
    private final PaymentRepository repository;

    public PaymentProcessorImpl(PaymentRepository repository) {
        this.repository = repository;
        this.executor = Executors.newFixedThreadPool(5);
    }

    @Override
    public void process(Payment payment) {
        executor.submit(new PaymentWorker(payment, repository));
    }
}
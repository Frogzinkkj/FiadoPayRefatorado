package com.example.FiadoPayRefatorado.infrastructure.webhook;

import com.example.FiadoPayRefatorado.domain.enums.WebhookStatus;
import com.example.FiadoPayRefatorado.domain.model.WebhookEvent;
import com.example.FiadoPayRefatorado.repository.WebhookEventRepository;

import java.time.LocalDateTime;

public class WebhookWorker implements Runnable {

    private final WebhookEvent webhook;
    private final WebhookEventRepository repository;

    public WebhookWorker(WebhookEvent webhook, WebhookEventRepository repository) {
        this.webhook = webhook;
        this.repository = repository;
    }

    @Override
    public void run() {
        try {
            if (!webhook.getSignature().equals("batata")) {
                webhook.setStatus(WebhookStatus.REJECTED);
                repository.save(webhook);
                return;
            }

            Thread.sleep(1500);

            webhook.setStatus(WebhookStatus.VALIDATED);
            webhook.setProcessedAt(LocalDateTime.now());
            repository.save(webhook);

        } catch (Exception e) {
            webhook.setStatus(WebhookStatus.REJECTED);
            repository.save(webhook);
        }
    }
}
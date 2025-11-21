package com.example.FiadoPayRefatorado.infrastructure.webhook;

import com.example.FiadoPayRefatorado.domain.contracts.WebhookDispatcher;
import com.example.FiadoPayRefatorado.domain.model.WebhookEvent;
import com.example.FiadoPayRefatorado.repository.WebhookEventRepository;
import org.springframework.stereotype.Component;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Component
public class WebhookDispatcherImpl implements WebhookDispatcher {

    private final ExecutorService executor;
    private final WebhookEventRepository repository;

    public WebhookDispatcherImpl(WebhookEventRepository repository) {
        this.repository = repository;
        this.executor = Executors.newFixedThreadPool(3);
    }

    @Override
    public void dispatch(WebhookEvent webhookEvent) {
        executor.submit(new WebhookWorker(webhookEvent, repository));
    }
}
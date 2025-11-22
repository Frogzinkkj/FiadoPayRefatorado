package com.example.FiadoPayRefatorado.domain.model;

import com.example.FiadoPayRefatorado.domain.enums.WebhookStatus;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "webhook_events")
public class WebhookEvent {

    @Id
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    @Column(name = "signature", nullable = false)
    private String signature;

    @Column(name = "payload", columnDefinition = "TEXT")
    private String payload;

    @Column(name = "event_type")
    private String eventType;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private WebhookStatus status;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "processed_at")
    private LocalDateTime processedAt;

    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

    public WebhookEvent() {
    }

    public WebhookEvent(String signature, String payload, String eventType) {
        this.signature = signature;
        this.payload = payload;
        this.eventType = eventType;
        this.id = UUID.randomUUID();
        this.createdAt = LocalDateTime.now();
        this.processedAt = null;
        this.updatedAt = LocalDateTime.now();
        this.status = WebhookStatus.RECEIVED;
    }

    public UUID getId() {
        return id;
    }

    public String getSignature() {
        return signature;
    }

    public String getPayload() {
        return payload;
    }

    public String getEventType() {
        return eventType;
    }

    public WebhookStatus getStatus() {
        return status;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getProcessedAt() {
        return processedAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setStatus(WebhookStatus status) {
        this.status = status;
        this.updatedAt = LocalDateTime.now();
    }

    public void setPayload(String payload) {
        this.payload = payload;
    }

    public void setProcessedAt(LocalDateTime processedAt) {
        this.processedAt = processedAt;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }
}
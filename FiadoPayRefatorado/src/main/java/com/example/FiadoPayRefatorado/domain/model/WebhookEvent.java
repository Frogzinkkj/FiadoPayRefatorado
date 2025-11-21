package com.example.FiadoPayRefatorado.domain.model;

import com.example.FiadoPayRefatorado.domain.enums.WebhookStatus;

import java.time.LocalDateTime;
import java.util.UUID;

public class WebhookEvent {
  private UUID id;
  private String signature, payload, eventType;
  private WebhookStatus status;
  private LocalDateTime createdAt;
  private LocalDateTime processedAt;
  private LocalDateTime updatedAt;

  public WebhookEvent(String signature, String payload, String eventType) {
    this.signature = signature;
    this.payload = payload;
    this.eventType = eventType;
    id= UUID.randomUUID();
    createdAt=LocalDateTime.now();
    processedAt=null;
    updatedAt=LocalDateTime.now();
    status = WebhookStatus.RECEIVED;
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
    updatedAt = LocalDateTime.now();
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

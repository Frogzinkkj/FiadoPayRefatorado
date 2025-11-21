package com.example.FiadoPayRefatorado.api.dto.webhook;

public class WebhookEventDTO {
  private String payload,signature;

  public WebhookEventDTO(String payload, String signature) {
    this.payload = payload;
    this.signature = signature;
  }

  public String getPayload() {
    return payload;
  }

  public void setPayload(String payload) {
    this.payload = payload;
  }

  public String getSignature() {
    return signature;
  }

  public void setSignature(String signature) {
    this.signature = signature;
  }
}

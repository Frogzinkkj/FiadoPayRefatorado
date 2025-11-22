package com.example.FiadoPayRefatorado.api.mapper;

import com.example.FiadoPayRefatorado.api.dto.webhook.WebhookEventDTO;
import com.example.FiadoPayRefatorado.domain.model.WebhookEvent;
import org.springframework.stereotype.Component;

@Component
public class WebhookMapper {
  public WebhookEvent toDomain(WebhookEventDTO dto){
    return new WebhookEvent(
        dto.getSignature(), dto.getPayload(), "PAYMENT_RECEIVED"
    );
  }
}

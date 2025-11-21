package com.example.FiadoPayRefatorado.domain.contracts;

import com.example.FiadoPayRefatorado.domain.model.WebhookEvent;

public interface WebhookDispatcher {
  public void dispatch(WebhookEvent webhookEvent);
}

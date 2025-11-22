package com.example.FiadoPayRefatorado.reflections;

import com.example.FiadoPayRefatorado.annotations.PaymentMethod;
import com.example.FiadoPayRefatorado.domain.contracts.PaymentProcessor;
import com.example.FiadoPayRefatorado.domain.enums.PaymentMethodType;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class PaymentMethodRegistry {

    @Bean
    public Map<PaymentMethodType, PaymentProcessor> paymentProcessors(ApplicationContext context) {
        Map<PaymentMethodType, PaymentProcessor> processors = new HashMap<>();
        context.getBeansWithAnnotation(PaymentMethod.class).forEach((name, bean) -> {
            PaymentMethod annotation = bean.getClass().getAnnotation(PaymentMethod.class);
            if (bean instanceof PaymentProcessor) {
                processors.put(annotation.value(), (PaymentProcessor) bean);
            }
        });
        return processors;
    }
}

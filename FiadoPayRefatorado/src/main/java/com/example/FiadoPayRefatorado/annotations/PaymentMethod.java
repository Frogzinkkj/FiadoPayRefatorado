package com.example.FiadoPayRefatorado.annotations;

import com.example.FiadoPayRefatorado.domain.enums.PaymentMethodType;
import org.springframework.stereotype.Component;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Component
public @interface PaymentMethod {
    PaymentMethodType value();
}

package com.payflow.paymentgateway.infrastructure;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {

    public static final String EXCHANGE = "payment.exchange";
    public static final String QUEUE = "payment.notification";
    public static final String ROUTING_KEY = "payment.notification";

    @Bean
    public DirectExchange paymentExchange() {
        return new DirectExchange(EXCHANGE);
    }

    @Bean
    public Queue paymentQueue() {
        return QueueBuilder.durable(QUEUE).build();
    }

    @Bean
    public Binding paymentBinding() {
        return BindingBuilder
                .bind(paymentQueue())
                .to(paymentExchange())
                .with(ROUTING_KEY);
    }


}

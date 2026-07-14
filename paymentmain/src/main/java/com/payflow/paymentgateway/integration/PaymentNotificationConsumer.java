package com.payflow.paymentgateway.integration;

import com.payflow.paymentgateway.module.service.PaymentService;
import com.payflow.paymentgateway.shared.dto.PaymentGatewayResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class PaymentNotificationConsumer {

    private final PaymentService paymentService;

    @RabbitListener(queues = "payment.notification")
    public void receive(PaymentGatewayResponse response) {

        log.info("Receive Payment : {}", response);
        paymentService.savePaymentHistoryDb(response);

    }

}

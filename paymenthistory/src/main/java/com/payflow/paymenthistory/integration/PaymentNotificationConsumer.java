package com.payflow.paymenthistory.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.payflow.paymenthistory.database.mongodb.PaymentAudit;
import com.payflow.paymenthistory.database.repository.PaymentAuditRepository;
import com.payflow.paymenthistory.module.service.PaymentService;
import com.payflow.paymenthistory.shared.dto.PaymentCreatedEvent;
import com.payflow.paymenthistory.shared.dto.PaymentGatewayResponse;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Slf4j
@Component
@RequiredArgsConstructor
public class PaymentNotificationConsumer {

    private final PaymentService paymentService;
    private final ObjectMapper objectMapper;
    private final PaymentAuditRepository paymentAuditRepository;

    @SneakyThrows
    @RabbitListener(queues = "payment.notification")
    public void receive(PaymentCreatedEvent event) {

        log.info("Receive Payment : {}", event);

        PaymentAudit audit = PaymentAudit.builder()
                .referenceNo(event.getReferenceNo())
                .userId(event.getUserId())
                .merchantType(event.getMerchantType())
                .amount(event.getAmount())
                .status(event.getStatus())
                .request(objectMapper.writeValueAsString(event))
                .response("SUCCESS")
                .duration(150L)
                .createdAt(LocalDateTime.now())
                .build();

        paymentAuditRepository.save(audit);

        log.info("Payment audit saved : {}", event.getReferenceNo());


    }

}

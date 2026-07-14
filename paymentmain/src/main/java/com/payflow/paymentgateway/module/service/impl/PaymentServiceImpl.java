package com.payflow.paymentgateway.module.service.impl;

import com.payflow.paymentgateway.database.entity.Payment;
import com.payflow.paymentgateway.database.repository.PaymentRepository;
import com.payflow.paymentgateway.integration.PayeeGatewayClients;
import com.payflow.paymentgateway.module.service.PaymentService;
import com.payflow.paymentgateway.shared.dto.PaymentGatewayResponse;
import com.payflow.paymentgateway.shared.dto.PaymentRequest;
import com.payflow.paymentgateway.shared.dto.PaymentResponse;
import com.payflow.paymentgateway.shared.enums.PaymentStatus;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@AllArgsConstructor
public class PaymentServiceImpl implements PaymentService {

    private PayeeGatewayClients payeeGatewayClients;
    private PaymentRepository paymentRepository;
    private final RedisTemplate<String, Object> redisTemplate;

    @Override
    public Payment createPayment(PaymentRequest request) {
        request.setReferenceNo(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmSS"))+request.getUserId()+ UUID.randomUUID());
        PaymentStatus paymentStatus = PaymentStatus.PENDING;
        Payment payment = new Payment();
        BeanUtils.copyProperties(request,payment);
        payment.setStatus(paymentStatus);
        paymentRepository.save(payment);

        redisTemplate.opsForHash().put(
                "payment:" + payment.getReferenceNo(),
                "status",
                paymentStatus
        );

        return payment;
    }

    @Override
    public PaymentResponse getPayment(String referenceNo) {
        return null;
    }

    @Override
    public List<PaymentResponse> getPaymentHistory(Long userId, String status) {
        return null;
    }

    @Override
    public PaymentResponse confirmPayment(String referenceNo) {
        return payeeGatewayClients.confirmPayment(referenceNo);
    }

    @Override
    public PaymentResponse cancelPayment(String referenceNo) {
        return payeeGatewayClients.cancelPayment(referenceNo);
    }

    @Override
    public PaymentResponse refundPayment(String referenceNo) {
        return payeeGatewayClients.refundPayment(referenceNo);
    }

    @Override
    public void savePaymentHistoryDb(PaymentGatewayResponse response) {
        Payment payment = new Payment();
        BeanUtils.copyProperties(response,payment);
        paymentRepository.save(payment);
    }
}

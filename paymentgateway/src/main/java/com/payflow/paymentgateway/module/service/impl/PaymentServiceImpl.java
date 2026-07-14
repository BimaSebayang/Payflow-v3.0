package com.payflow.paymentgateway.module.service.impl;

import com.payflow.paymentgateway.integration.PayeeGatewayClients;
import com.payflow.paymentgateway.module.service.PaymentService;
import com.payflow.paymentgateway.shared.dto.PaymentRequest;
import com.payflow.paymentgateway.shared.dto.PaymentResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {

    private PayeeGatewayClients payeeGatewayClients;

    @Override
    public PaymentResponse createPayment(PaymentRequest request) {
        return payeeGatewayClients.send(request);
    }


    @Override
    public PaymentResponse confirmPayment(String referenceNo) {
        return null;
    }

    @Override
    public PaymentResponse cancelPayment(String referenceNo) {
        return null;
    }

    @Override
    public PaymentResponse refundPayment(String referenceNo) {
        return null;
    }
}

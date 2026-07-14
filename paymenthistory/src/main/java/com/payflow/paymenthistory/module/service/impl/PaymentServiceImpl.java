package com.payflow.paymenthistory.module.service.impl;

import com.payflow.paymenthistory.integration.PayeeGatewayClients;
import com.payflow.paymenthistory.module.service.PaymentService;
import com.payflow.paymenthistory.shared.dto.PaymentGatewayResponse;
import com.payflow.paymenthistory.shared.dto.PaymentRequest;
import com.payflow.paymenthistory.shared.dto.PaymentResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {

    private PayeeGatewayClients payeeGatewayClients;

    @Override
    public PaymentResponse getPayment(String referenceNo) {
        return null;
    }

    @Override
    public List<PaymentResponse> getPaymentHistory(Long userId, String status) {
        return null;
    }

    @Override
    public void savePaymentHistoryMongo(PaymentGatewayResponse response) {

    }
}

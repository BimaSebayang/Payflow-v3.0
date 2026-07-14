package com.payflow.paymenthistory.module.service;

import com.payflow.paymenthistory.shared.dto.PaymentRequest;
import com.payflow.paymenthistory.shared.dto.PaymentResponse;

import java.util.List;

public interface PaymentService {


    PaymentResponse getPayment(String referenceNo);

    List<PaymentResponse> getPaymentHistory(Long userId, String status);

}

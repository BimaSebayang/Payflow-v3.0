package com.payflow.paymentgateway.integration;

import com.payflow.paymentgateway.shared.dto.PaymentRequest;
import com.payflow.paymentgateway.shared.dto.PaymentResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "${external.historypayee.name}", url = "${external.historypayee.url}")
public interface HistoryGatewayClients {

    @GetMapping("/{referenceNo}")
    PaymentResponse getPayment(@RequestBody PaymentRequest request);

    @GetMapping
    List<PaymentResponse> getPaymentHistory( @RequestParam(required = false) Long userId,
                                             @RequestParam(required = false) String status);
}

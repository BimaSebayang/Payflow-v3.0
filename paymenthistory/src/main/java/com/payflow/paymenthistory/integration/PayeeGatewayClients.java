package com.payflow.paymenthistory.integration;

import com.payflow.paymenthistory.shared.dto.PaymentRequest;
import com.payflow.paymenthistory.shared.dto.PaymentResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "${external.gatewaypayee.name}", url = "${external.gatewaypayee.url}")
public interface PayeeGatewayClients {

    @PostMapping("/api-gateway/v1/payments")
    PaymentResponse send(@RequestBody PaymentRequest request);
}

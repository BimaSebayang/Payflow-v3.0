package com.payflow.paymentgateway.integration;

import com.payflow.paymentgateway.shared.dto.PaymentRequest;
import com.payflow.paymentgateway.shared.dto.PaymentResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "${external.gatewaypayee.name}", url = "${external.gatewaypayee.url}")
public interface PayeeGatewayClients {

    @PostMapping("/v1/payments")
    PaymentResponse createPayments(@RequestBody PaymentRequest request);

    @PostMapping("/{referenceNo}/confirm")
    PaymentResponse confirmPayment(@PathVariable String referenceNo);

    @PostMapping("/{referenceNo}/cancel")
    PaymentResponse cancelPayment(@PathVariable String referenceNo);

    @PostMapping("/{referenceNo}/refund")
    PaymentResponse refundPayment(@PathVariable String referenceNo);

}

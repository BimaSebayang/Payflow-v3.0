package com.payflow.paymentgateway.shared.dto;

import com.payflow.paymentgateway.shared.enums.PaymentStatus;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Setter
@Getter
public class PaymentGatewayResponse {
    private PaymentStatus status;
    private String message;
}

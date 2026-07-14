package com.payflow.paymenthistory.shared.dto;

import com.payflow.paymenthistory.shared.enums.PaymentStatus;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Setter
@Getter
@NoArgsConstructor
public class PaymentGatewayResponse {
    private PaymentStatus status;
    private String message;
}

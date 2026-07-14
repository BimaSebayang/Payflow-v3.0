package com.payflow.paymenthistory.shared.dto;

import com.payflow.paymenthistory.shared.enums.Currency;
import com.payflow.paymenthistory.shared.enums.MerchantType;
import com.payflow.paymenthistory.shared.enums.PaymentMethod;
import com.payflow.paymenthistory.shared.enums.PaymentStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PaymentCreatedEvent {
    private String referenceNo;

    private MerchantType merchantType;

    private Long userId;

    private BigDecimal amount;

    private Currency currency;

    private PaymentMethod paymentMethod;

    private PaymentStatus status;

    private String description;

    private LocalDateTime transactionTime;
}

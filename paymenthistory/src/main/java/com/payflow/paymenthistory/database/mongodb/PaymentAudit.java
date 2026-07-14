package com.payflow.paymenthistory.database.mongodb;

import com.payflow.paymenthistory.shared.enums.MerchantType;
import com.payflow.paymenthistory.shared.enums.PaymentStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "payment_audit")
public class PaymentAudit {
    @Id
    private String id;

    private String referenceNo;

    private Long userId;

    private MerchantType merchantType;

    private BigDecimal amount;

    private PaymentStatus status;

    private String request;

    private String response;

    private Long duration;

    private LocalDateTime createdAt;
}

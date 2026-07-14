package com.payflow.paymenthistory.database.repository;

import com.payflow.paymenthistory.database.mongodb.PaymentAudit;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PaymentAuditRepository extends MongoRepository<PaymentAudit, String> {
}

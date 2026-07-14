package com.payflow.paymentgateway.module.controller;

import com.payflow.paymentgateway.database.entity.Payment;
import com.payflow.paymentgateway.module.service.PaymentService;
import com.payflow.paymentgateway.shared.dto.PaymentRequest;
import com.payflow.paymentgateway.shared.dto.PaymentResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api-pay/v1/payments")
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentService paymentService;

    @PostMapping
    public ResponseEntity<Payment> createPayment(
            @Valid @RequestBody PaymentRequest request) {

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(paymentService.createPayment(request));
    }

    @GetMapping("/{referenceNo}")
    public ResponseEntity<PaymentResponse> getPayment(
            @PathVariable String referenceNo) {

        return ResponseEntity.ok(
                paymentService.getPayment(referenceNo));
    }

    @GetMapping
    public ResponseEntity<List<PaymentResponse>> getPaymentHistory(
            @RequestParam(required = false) Long userId,
            @RequestParam(required = false) String status) {

        return ResponseEntity.ok(
                paymentService.getPaymentHistory(userId, status));
    }

    @PostMapping("/{referenceNo}/confirm")
    public ResponseEntity<PaymentResponse> confirmPayment(
            @PathVariable String referenceNo) {

        return ResponseEntity.ok(
                paymentService.confirmPayment(referenceNo));
    }


    @PostMapping("/{referenceNo}/cancel")
    public ResponseEntity<PaymentResponse> cancelPayment(
            @PathVariable String referenceNo) {

        return ResponseEntity.ok(
                paymentService.cancelPayment(referenceNo));
    }

    @PostMapping("/{referenceNo}/refund")
    public ResponseEntity<PaymentResponse> refundPayment(
            @PathVariable String referenceNo) {

        return ResponseEntity.ok(
                paymentService.refundPayment(referenceNo));
    }

}

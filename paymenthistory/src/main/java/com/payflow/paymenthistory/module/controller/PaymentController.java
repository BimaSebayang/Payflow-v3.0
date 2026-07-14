package com.payflow.paymenthistory.module.controller;

import com.payflow.paymenthistory.module.service.PaymentService;
import com.payflow.paymenthistory.shared.dto.PaymentRequest;
import com.payflow.paymenthistory.shared.dto.PaymentResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/payee-history/v1/payments")
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentService paymentService;



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

}

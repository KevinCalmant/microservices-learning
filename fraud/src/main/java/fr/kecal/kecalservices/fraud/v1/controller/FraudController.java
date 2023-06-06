package fr.kecal.kecalservices.fraud.v1.controller;

import fr.kecal.kecalservices.clients.fraud.model.FraudCheckResponse;
import fr.kecal.kecalservices.fraud.v1.services.FraudCheckHistoryService;
import java.util.UUID;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("api/v1/fraud-check")
public record FraudController(FraudCheckHistoryService fraudCheckHistoryService) {
    @GetMapping(path ="{customerId}")
    public ResponseEntity<FraudCheckResponse> isFraudster(@PathVariable("customerId") UUID customerId) {
        log.info("fraud check request for customer {}", customerId);
        return new ResponseEntity<>(
            new FraudCheckResponse(fraudCheckHistoryService.isFraudulentCustomer(customerId)),
            HttpStatus.OK
        );
    }
}

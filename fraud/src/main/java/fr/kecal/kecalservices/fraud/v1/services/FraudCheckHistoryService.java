package fr.kecal.kecalservices.fraud.v1.services;

import fr.kecal.kecalservices.fraud.v1.domain.FraudCheckHistory;
import fr.kecal.kecalservices.fraud.v1.repository.FraundCheckHistoryRepository;
import java.time.LocalDateTime;
import java.util.UUID;
import org.springframework.stereotype.Service;

@Service
public record FraudCheckHistoryService(FraundCheckHistoryRepository fraundCheckHistoryRepository) {
    public boolean isFraudulentCustomer(UUID customerId) {
        fraundCheckHistoryRepository.save(
            FraudCheckHistory.builder()
                .customerId(customerId)
                .isFraudster(false)
                .createdAt(LocalDateTime.now())
                .build()
        );
        return false;
    }
}

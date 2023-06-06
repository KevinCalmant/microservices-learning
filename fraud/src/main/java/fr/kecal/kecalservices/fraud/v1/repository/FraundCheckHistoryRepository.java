package fr.kecal.kecalservices.fraud.v1.repository;

import fr.kecal.kecalservices.fraud.v1.domain.FraudCheckHistory;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FraundCheckHistoryRepository extends JpaRepository<FraudCheckHistory, UUID> {
}

package fr.kecal.kecalservices.customer.v1.repository;

import fr.kecal.kecalservices.customer.v1.domain.Customer;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, UUID> {
}

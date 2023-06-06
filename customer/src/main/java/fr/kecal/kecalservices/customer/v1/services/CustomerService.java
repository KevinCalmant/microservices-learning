package fr.kecal.kecalservices.customer.v1.services;

import fr.kecal.kecalservices.amqp.RabbitMQMessageProducer;
import fr.kecal.kecalservices.clients.fraud.FraudClient;
import fr.kecal.kecalservices.clients.notification.NotificationClient;
import fr.kecal.kecalservices.clients.notification.model.NotificationRequest;
import fr.kecal.kecalservices.customer.v1.domain.Customer;
import fr.kecal.kecalservices.customer.v1.model.CustomerRegistrationRequest;
import fr.kecal.kecalservices.customer.v1.repository.CustomerRepository;
import java.time.LocalDateTime;
import org.springframework.stereotype.Service;

@Service
public record CustomerService(
    CustomerRepository customerRepository,
    FraudClient fraudClient,
    RabbitMQMessageProducer rabbitMQMessageProducer
) {
    public void registerCustomer(CustomerRegistrationRequest customerRegistrationRequest) {
        Customer customer = Customer.builder()
            .firstname(customerRegistrationRequest.firstName())
            .lastName(customerRegistrationRequest.lastName())
            .email(customerRegistrationRequest.email())
            .build();
        customerRepository.saveAndFlush(customer);
        if (fraudClient.isFraudster(customer.getId()).isFraudster()) {
            throw new IllegalStateException("Customer is a fraudster");
        }
        var notificationRequest = new NotificationRequest(
            customer.getId(),
            customer.getEmail(),
            String.format("Hi %s, welcome to KeCalServices", customer.getFirstname())
        );
        rabbitMQMessageProducer.publish(notificationRequest, "internal.exchange", "internal.notification.routing-key");
    }
}

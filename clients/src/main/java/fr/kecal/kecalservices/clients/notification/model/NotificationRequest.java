package fr.kecal.kecalservices.clients.notification.model;

import java.io.Serializable;
import java.util.UUID;

public record NotificationRequest(UUID toCustomerId, String toCustomerEmail, String message) implements Serializable {
}

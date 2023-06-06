package fr.kecal.kecalservices.customer.v1.model;

public record CustomerRegistrationRequest(
    String firstName,
    String lastName,
    String email
) {
}

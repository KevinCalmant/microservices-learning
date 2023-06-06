package fr.kecal.kecalservices.notification.v1.services;

import fr.kecal.kecalservices.clients.notification.model.NotificationRequest;
import fr.kecal.kecalservices.notification.v1.domain.Notification;
import fr.kecal.kecalservices.notification.v1.repository.NotificationRepository;
import java.time.LocalDateTime;
import org.springframework.stereotype.Service;

@Service
public record NotificationService(NotificationRepository notificationRepository) {
    public void saveNotification(NotificationRequest notificationRequest) {
        var notification = Notification.builder()
            .message(notificationRequest.message())
            .sender("KeCal")
            .toCustomerId(notificationRequest.toCustomerId())
            .toCustomerEmail(notificationRequest.toCustomerEmail())
            .sentAt(LocalDateTime.now())
            .build();
        notificationRepository.save(notification);
    }
}

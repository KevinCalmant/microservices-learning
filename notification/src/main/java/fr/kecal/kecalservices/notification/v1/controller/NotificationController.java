package fr.kecal.kecalservices.notification.v1.controller;

import fr.kecal.kecalservices.clients.notification.model.NotificationRequest;
import fr.kecal.kecalservices.notification.v1.services.NotificationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("api/v1/notifications")
public record NotificationController(NotificationService notificationService) {
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    void sendNotification(@RequestBody NotificationRequest notificationRequest) {
        log.info("New notification {}", notificationRequest);
        notificationService.saveNotification(notificationRequest);
    }
}

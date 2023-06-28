package fr.kecal.kecalservices.clients.notification;

import fr.kecal.kecalservices.clients.notification.model.NotificationRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@FeignClient(
    name = "notification",
    url = "${clients.notification.url}"
)
public interface NotificationClient {
    @PostMapping(path = "api/v1/notifications")
    @ResponseStatus(HttpStatus.CREATED)
    void notify(@RequestBody NotificationRequest notificationRequest);
}

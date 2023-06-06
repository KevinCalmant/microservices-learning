package fr.kecal.kecalservices.notification.v1.consumer;

import fr.kecal.kecalservices.clients.notification.model.NotificationRequest;
import fr.kecal.kecalservices.notification.v1.services.NotificationService;
import io.micrometer.observation.Observation;
import io.micrometer.observation.ObservationRegistry;
import io.micrometer.tracing.Tracer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public record NotificationConsumer(NotificationService notificationService, Tracer tracer, ObservationRegistry observationRegistry) {
    @RabbitListener(queues = "${rabbit.queue.notification}")
    public void consumer(NotificationRequest notificationRequest) {
        Observation.createNotStarted("on-message", this.observationRegistry).observe(() -> {
            log.info("Consumed {} from queue", notificationRequest);
            notificationService.saveNotification(notificationRequest);
        });
    }
}

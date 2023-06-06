package fr.kecal.kecalservices.notification.v1.repository;

import fr.kecal.kecalservices.notification.v1.domain.Notification;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationRepository extends JpaRepository<Notification, UUID> {
}

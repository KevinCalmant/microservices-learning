package fr.kecal.kecalservices.notification;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients(basePackages = "fr.kecal.kecalservices.clients")
@SpringBootApplication(
    scanBasePackages = {
        "fr.kecal.kecalservices.notification",
        "fr.kecal.kecalservices.amqp"
    }
)
public class NotificationApplication {
    public static void main(String[] args) {
        SpringApplication.run(NotificationApplication.class, args);
    }
}

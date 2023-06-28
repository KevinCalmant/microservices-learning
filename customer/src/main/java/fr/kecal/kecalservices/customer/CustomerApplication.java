package fr.kecal.kecalservices.customer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@EnableFeignClients(basePackages = "fr.kecal.kecalservices.clients")
@SpringBootApplication(
    scanBasePackages = {
        "fr.kecal.kecalservices.customer",
        "fr.kecal.kecalservices.amqp"
    }
)
@PropertySources({
    @PropertySource("classpath:clients-${spring.profiles.active}.properties")
})
public class CustomerApplication {
    public static void main(String[] args) {
        SpringApplication.run(CustomerApplication.class, args);
    }
}

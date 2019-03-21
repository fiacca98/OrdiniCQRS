package main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jms.annotation.EnableJms;

@ComponentScan("org.its")
@SpringBootApplication
@EnableJms
public class OrdiniCQRS {
    public static void main(String[] args) {
        SpringApplication.run(OrdiniCQRS.class, args);
    }
}


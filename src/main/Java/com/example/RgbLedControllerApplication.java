package com.example.rgbled; // Note the case change from rgbLed to rgbled

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RgbLedControllerApplication {

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(RgbLedControllerApplication.class);
        application.setAdditionalProfiles("default"); // You can set any profiles if necessary
        application.run(args);
    }
}

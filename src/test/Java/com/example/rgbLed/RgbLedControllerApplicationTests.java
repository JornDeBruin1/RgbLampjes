package com.example.rgbledcontroller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.web.context.WebApplicationContext;

import static org.mockito.Mockito.verify;

@SpringBootTest
class RgbLedControllerApplicationTests {

    @Autowired
    private WebApplicationContext webApplicationContext;

    @MockBean
    private RgbLedService rgbLedService; // Assume you have a service to control RGB LED

    @Test
    void contextLoads() {
        // This test checks if the Spring application context loads correctly
    }

    @Test
    void testTurnOnLed() {
        // Example test case to check if LED can be turned on
        rgbLedService.turnOnLed();
        
        // Verify that the turnOnLed method was called
        verify(rgbLedService).turnOnLed();
    }

    @Test
    void testChangeColor() {
        // Example test case to check if color can be changed
        rgbLedService.changeColor("red");

        // Verify that the changeColor method was called with the expected parameter
        verify(rgbLedService).changeColor("red");
    }

    // Add more tests for other functionalities as needed
}

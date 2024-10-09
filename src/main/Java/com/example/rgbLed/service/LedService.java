package com.example.rgbled.service;

import com.pi4j.Pi4J;
import com.pi4j.context.Context;
import com.pi4j.io.gpio.digital.DigitalInput;
import com.pi4j.io.gpio.digital.DigitalInputConfigBuilder;
import com.pi4j.io.gpio.digital.DigitalOutput;
import com.pi4j.io.gpio.digital.DigitalOutputConfigBuilder;
import com.pi4j.io.gpio.digital.DigitalState;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class LedService {

    private static final int TOUCH_SENSOR_PIN = 17;  // GPIO Pin for the touch sensor (uncommented)
    private static final int LED_PIN = 18;          // GPIO Pin for WS2812 LEDs

    private Context pi4j;
    private DigitalOutput ledOutput;
    private DigitalInput touchInput;

    // Example RGB colors
    private List<int[]> colors = Arrays.asList(
            new int[]{255, 0, 0},  // Red
            new int[]{0, 255, 0},  // Green
            new int[]{0, 0, 255}   // Blue
    );

    public LedService() {
        // Initialize Pi4J Context
        pi4j = Pi4J.newAutoContext();

        // Initialize LED output pin
        DigitalOutputConfigBuilder ledConfig = DigitalOutput.newConfigBuilder(pi4j)
                .id("led")
                .name("RGB LED")
                .address(LED_PIN)
                .shutdown(DigitalState.LOW);  // Updated

        ledOutput = pi4j.create(ledConfig);

        // Initialize touch sensor input pin
        DigitalInputConfigBuilder touchConfig = DigitalInput.newConfigBuilder(pi4j)
                .id("touch")
                .name("Touch Sensor")
                .address(TOUCH_SENSOR_PIN);
        touchInput = pi4j.create(touchConfig);
    }

    public void setColor(int r, int g, int b) {
        System.out.println("Set LED color to RGB(" + r + ", " + g + ", " + b + ")");
    }

    public void cycleColors() {
        for (int[] color : colors) {
            setColor(color[0], color[1], color[2]);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}

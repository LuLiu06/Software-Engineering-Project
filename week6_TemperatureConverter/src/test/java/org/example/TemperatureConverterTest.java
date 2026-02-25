package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TemperatureConverterTest {

    private TemperatureConverter converter;

    @BeforeEach
    void setUp() {
        converter = new TemperatureConverter();
    }

    @Test
    void testFahrenheitToCelsius() {
        assertEquals(0, converter.fahrenheitToCelsius(32), 0.001);
        assertEquals(100, converter.fahrenheitToCelsius(212), 0.001);
        assertEquals(-40, converter.fahrenheitToCelsius(-40), 0.001);
    }

    @Test
    void testCelsiusToFahrenheit() {
        assertEquals(32, converter.celsiusToFahrenheit(0), 0.001);
        assertEquals(212, converter.celsiusToFahrenheit(100), 0.001);
        assertEquals(-40, converter.celsiusToFahrenheit(-40), 0.001);
    }

    @Test
    void testIsExtremeTemperature() {
        assertTrue(converter.isExtremeTemperature(-50));
        assertTrue(converter.isExtremeTemperature(60));

        assertFalse(converter.isExtremeTemperature(-40));
        assertFalse(converter.isExtremeTemperature(0));
        assertFalse(converter.isExtremeTemperature(50));
    }

    @Test
    void testKelvinToCelsius() {
        // 0 K (absolute zero) = -273.15°C
        assertEquals(-273.15, converter.kelvinToCelsius(0), 0.001);
        
        // 273.15 K = 0°C (freezing point of water)
        assertEquals(0, converter.kelvinToCelsius(273.15), 0.001);
        
        // 373.15 K = 100°C (boiling point of water)
        assertEquals(100, converter.kelvinToCelsius(373.15), 0.001);
        
        // 300 K = 26.85°C (example from assignment)
        assertEquals(26.85, converter.kelvinToCelsius(300), 0.001);
    }
}



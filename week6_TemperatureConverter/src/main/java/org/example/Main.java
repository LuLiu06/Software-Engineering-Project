package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TemperatureConverter converter = new TemperatureConverter();
        Scanner scanner = new Scanner(System.in);

        System.out.println("╔════════════════════════════════════════╗");
        System.out.println("║     TEMPERATURE CONVERTER v1.0         ║");
        System.out.println("║     Week 6 - Docker Assignment         ║");
        System.out.println("╚════════════════════════════════════════╝");
        System.out.println();

        boolean continueRunning = true;

        while (continueRunning) {
            System.out.println("Available conversions:");
            System.out.println("  1. Fahrenheit to Celsius");
            System.out.println("  2. Celsius to Fahrenheit");
            System.out.println("  3. Kelvin to Celsius");
            System.out.println("  4. Exit");
            System.out.println();
            System.out.print("Choose option (1-4): ");

            int choice = scanner.nextInt();

            if (choice == 4) {
                System.out.println();
                System.out.println("Thank you for using Temperature Converter!");
                System.out.println("Goodbye!");
                continueRunning = false;
                continue;
            }

            if (choice < 1 || choice > 3) {
                System.out.println("Invalid option. Please try again.");
                System.out.println();
                continue;
            }

            System.out.print("Enter temperature value: ");
            double temp = scanner.nextDouble();

            double result;
            String output;

            switch (choice) {
                case 1:
                    result = converter.fahrenheitToCelsius(temp);
                    output = String.format("%.2f°F = %.2f°C", temp, result);
                    System.out.println();
                    System.out.println("Converting Fahrenheit to Celsius...");
                    System.out.println("Result: " + output);
                    break;
                case 2:
                    result = converter.celsiusToFahrenheit(temp);
                    output = String.format("%.2f°C = %.2f°F", temp, result);
                    System.out.println();
                    System.out.println("Converting Celsius to Fahrenheit...");
                    System.out.println("Result: " + output);
                    break;
                case 3:
                    result = converter.kelvinToCelsius(temp);
                    output = String.format("%.2fK = %.2f°C", temp, result);
                    System.out.println();
                    System.out.println("Converting Kelvin to Celsius...");
                    System.out.println("Result: " + output);
                    break;
                default:
                    result = 0;
            }

            // Check for extreme temperature
            double celsius;
            switch (choice) {
                case 1:
                    celsius = converter.fahrenheitToCelsius(temp);
                    break;
                case 2:
                    celsius = temp;
                    break;
                case 3:
                    celsius = converter.kelvinToCelsius(temp);
                    break;
                default:
                    celsius = 0;
            }

            if (converter.isExtremeTemperature(celsius)) {
                System.out.println("⚠️  WARNING: This is an extreme temperature!");
            }

            System.out.println();
            System.out.println("----------------------------------------");
            System.out.println();
        }

        scanner.close();
    }
}

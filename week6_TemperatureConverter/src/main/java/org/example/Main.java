package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TemperatureConverter converter = new TemperatureConverter();
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Temperature Converter ===");
        System.out.println("1. Fahrenheit to Celsius");
        System.out.println("2. Celsius to Fahrenheit");
        System.out.println("3. Kelvin to Celsius");
        System.out.print("Choose option (1-3): ");

        int choice = scanner.nextInt();
        System.out.print("Enter temperature: ");
        double temp = scanner.nextDouble();

        double result;
        String output;

        switch (choice) {
            case 1:
                result = converter.fahrenheitToCelsius(temp);
                output = String.format("%.2f°F = %.2f°C", temp, result);
                break;
            case 2:
                result = converter.celsiusToFahrenheit(temp);
                output = String.format("%.2f°C = %.2f°F", temp, result);
                break;
            case 3:
                result = converter.kelvinToCelsius(temp);
                output = String.format("%.2fK = %.2f°C", temp, result);
                break;
            default:
                output = "Invalid option";
        }

        System.out.println(output);

        if (choice >= 1 && choice <= 3) {
            double celsius = (choice == 1) ? converter.fahrenheitToCelsius(temp) :
                             (choice == 2) ? temp :
                             converter.kelvinToCelsius(temp);
            if (converter.isExtremeTemperature(celsius)) {
                System.out.println("Warning: This is an extreme temperature!");
            }
        }

        scanner.close();
    }
}


package com.example.simple_mobile_calc;

public class InputValidator {
    public static Float validateFloat(String input, String fieldName) {
        if (input == null || input.trim().isEmpty()) {
            throw new ValidationException(fieldName + " не может быть пустым");
        }

        try {
            return Float.parseFloat(input.trim());
        } catch (NumberFormatException e) {
            throw new ValidationException(fieldName + " должно быть числом");
        }
    }


    public static Float validateFloat(String input, String fieldName, int min, int max) {
        Float value = validateFloat(input, fieldName);

        if (value < min || value > max) {
            throw new ValidationException(fieldName + " должно быть от " + min + " до " + max);
        }

        return value;
    }
}

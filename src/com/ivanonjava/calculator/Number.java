package com.ivanonjava.calculator;

public class Number {
    private int value;
    private boolean isRoman;

    public Number(String value) {
        try {
            this.value = Integer.parseInt(value);
        } catch (NumberFormatException e) {
            this.value = ConverterNumber.romanToArabic(value);
            isRoman = true;
        }
        if (this.value > 10) {
            throw new IllegalArgumentException(value + " is not in range (0,10]");
        }
    }

    public int getValue() {
        return value;
    }

    public boolean isRoman() {
        return isRoman;
    }
}

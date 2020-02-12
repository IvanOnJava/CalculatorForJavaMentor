package com.ivanonjava.calculator;


import com.ivanonjava.calculator.exceptions.NoOperationException;

public class Calculator {
    private Number value1;
    private Number value2;
    private String action;

    public String calculate(String task) throws Exception {
        preparingCalculator(task);
        int result = calculateTask();
        char subzero = result < 0 ? '-' : ' ';
        if (value2.isRoman()) {
            if (result == 0) {
                return "zero";
            } else {
                return subzero + ConverterNumber.arabicToRoman(Math.abs(result));
            }
        } else {
            return "" + subzero + Math.abs(result);
        }
    }

    private void preparingCalculator(String task) throws Exception {
        value1 = null;
        value2 = null;
        action = null;
        if (task.trim().length() < 3) {
            throw new Exception("Invalid request: " + task);
        }
        action = findAction(task);
        String[] values = task.split(action);
        if (values.length != 2) {
            throw new Exception("Invalid request: " + task);
        }
        value1 = new Number(values[0].trim());
        value2 = new Number(values[1].trim());
        if (value1.isRoman() != value2.isRoman()) {
            throw new Exception("Invalid request: " + task);
        }

    }

    private int calculateTask() throws Exception {
        switch (action) {
            case "\\*":
                return value1.getValue() * value2.getValue();
            case "/":
                if (value2.getValue() == 0) {
                    throw new ArithmeticException();
                }
                return value1.getValue() / value2.getValue();
            case "\\+":
                return value1.getValue() + value2.getValue();
            case "-":
                return value1.getValue() - value2.getValue();
            default:
                break;
        }
        throw new Exception(value1.getValue() + " " + action + " " + value2.getValue());
    }

    private String findAction(String task) throws Exception {
        for (char a : task.toCharArray()) {
            switch (a) {
                case '*':
                    return "\\*";
                case '/':
                    return "/";
                case '+':
                    return "\\+";
                case '-':
                    return "-";
                default:
                    break;
            }
        }
        throw new NoOperationException(task);
    }
}

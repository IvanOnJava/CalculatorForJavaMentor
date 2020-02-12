package com.ivanonjava;

import com.ivanonjava.calculator.Calculator;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String task = scanner.nextLine();
            String result;
            try {
                result = calculator.calculate(task);
            } catch (Exception e) {
                e.printStackTrace();
                break;
            }
            System.out.println(result);
        }
    }
}

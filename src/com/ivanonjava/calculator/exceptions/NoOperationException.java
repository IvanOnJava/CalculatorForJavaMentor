package com.ivanonjava.calculator.exceptions;

public class NoOperationException extends Exception {
    String task;
    public NoOperationException(String task) {
        super("No operation: " + task);
        this.task = task;
    }

    public String getTask() {
        return task;
    }
}

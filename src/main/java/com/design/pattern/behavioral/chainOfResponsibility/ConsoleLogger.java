package com.design.pattern.behavioral.chainOfResponsibility;

public class ConsoleLogger extends AbstractLogger{
    public ConsoleLogger(int level) {
        this.level = level;
    }

    @Override
    protected void write(String message) {
        this.level = level;
    }
}
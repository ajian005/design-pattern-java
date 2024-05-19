package com.design.pattern.creational.abstractFactory;

public class Circle  implements Shape{
    @Override
    public void draw() {
        System.out.println("Inside Circle::draw() method.");
    }
}

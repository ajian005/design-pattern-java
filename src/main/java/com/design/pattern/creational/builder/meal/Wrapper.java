package com.design.pattern.creational.builder.meal;

public class Wrapper  implements Packing {
    @Override
    public String pack() {
        return "Wrapper";
    }
}

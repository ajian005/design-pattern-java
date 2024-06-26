package com.design.pattern.creational.builder.meal;

public abstract class ColdDrink  implements Item{
    @Override
    public Packing packing() {
        return new Bottle();
    }

    @Override
    public abstract float price();
}

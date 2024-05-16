package com.design.pattern.creational.builder.product;

class Product {
    private String partA;
    private String partB;
    public Product() {}
    public void setPartA(String s) {
        partA = s;
    }
    public void setPartB(String s) {
        partB = s;
    }
}

interface Builder {
    public void buildPartA();
    public void buildPartB();
    public Product getResult();
}

class ConcreteBuilder1 implements Builder {
    private Product product;
    public ConcreteBuilder1() {
        product = new Product();
    }

    @Override
    public void buildPartA() {
        product.setPartA("Component A");
    }

    @Override
    public void buildPartB() {
        product.setPartB("Component B");
    }

    @Override
    public Product getResult() {
        return product;
    }
}


class ConcreteBuilder2 implements Builder {
    private Product product;
    public ConcreteBuilder2() {
        product = new Product();
    }

    @Override
    public void buildPartA() {
        product.setPartA("Component A");
    }

    @Override
    public void buildPartB() {
        product.setPartB("Component B");
    }

    @Override
    public Product getResult() {
        return product;
    }
}

class Director {
    private Builder builder;
    public Director(Builder builder) {
        this.builder = builder;
    }

    public void construct() {
        builder.buildPartA();
        builder.buildPartB();;
    }
}

public class ProductTest {
    public static void main(String[] args) {
        Director director1 = new Director( new ConcreteBuilder1() );
        director1.construct();
    }
}

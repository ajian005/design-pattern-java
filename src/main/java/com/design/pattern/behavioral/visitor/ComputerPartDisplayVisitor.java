package com.design.pattern.behavioral.visitor;

public class ComputerPartDisplayVisitor implements ComputerPartVisitor{
    @Override
    public void visit(Computer computer) {
        System.out.println("Display Computer.");
    }

    @Override
    public void visit(Mouse mouse) {
        System.out.println("Displaying mouse.");
    }

    @Override
    public void visit(Keyboard keyboard) {
        System.out.println("Displaying keyboard.");
    }

    @Override
    public void visit(Monitor monitor) {
        System.out.println("Displaying Monitor.");
    }
}

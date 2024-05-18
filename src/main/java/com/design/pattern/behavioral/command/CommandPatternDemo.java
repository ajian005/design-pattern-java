package com.design.pattern.behavioral.command;

public class CommandPatternDemo {
    public static void main(String[] args) {
        Stock absStock = new Stock();
        BuyStock buyStockOrder = new BuyStock(absStock);
        SellStock sellStockOrder = new SellStock(absStock);
        Broker broker = new Broker();
        broker.takeOrder(buyStockOrder);
        broker.takeOrder(sellStockOrder);

        broker.placeOrders();
    }
}

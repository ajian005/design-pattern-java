package com.design.pattern.behavioral.strategy;

interface BrakeBehavior{
    public void stop();
}

class LongWheelBrake implements BrakeBehavior {
    @Override
    public void stop() {
        System.out.println("模拟长轮胎刹车痕迹！");
    }
}

class ShortWheelBrake implements BrakeBehavior {
    public void stop() {
        System.out.println("模拟短轮胎刹车痕迹！");
    }
}

abstract class Car {
    protected BrakeBehavior  wheel;
    public void brake() {
        wheel.stop();
    }
}

class ShortWheelCar extends Car {
    public ShortWheelCar(BrakeBehavior behavior) {
        wheel = behavior;
    }
}

class LongWheelCar extends Car {
    public LongWheelCar(BrakeBehavior behavior) {
        wheel = behavior;
    }
}

public class StrategyTest {
    public static void main(String[] args) {
        BrakeBehavior brake = new ShortWheelBrake();
        ShortWheelCar car1  = new ShortWheelCar(brake);
        car1.brake();
        BrakeBehavior brake2 = new LongWheelBrake();
        LongWheelCar car12  = new LongWheelCar(brake2);
        car12.brake();
    }
}

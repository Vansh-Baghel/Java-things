package Interfaces.Car_Setup;

public class Car implements Brake, Engine , Media{

    @Override
    public void brake() {
        System.out.println("I pressed the brake");
    }

    @Override
    public void start() {
        System.out.println("I pressed the start");

    }

    @Override
    public void stop() {
        System.out.println("I stopped the Car");

    }

    @Override
    public void acc() {
        System.out.println("I accelerated the Car");
    }
}

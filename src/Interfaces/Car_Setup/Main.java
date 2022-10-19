package Interfaces.Car_Setup;

public class Main {
    public static void main(String[] args) {
        Car car = new Car();

        car.acc();
        car.start();
        car.stop();
        car.brake();

        Media media = new Music_Player();
        media.stop();
    }
}

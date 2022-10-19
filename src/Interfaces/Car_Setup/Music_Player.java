package Interfaces.Car_Setup;

public class Music_Player implements Media{

    @Override
    public void start() {
        System.out.println("The music has been started!! Enjoy!");
    }

    @Override
    public void stop() {
        System.out.println("The music has been stopped!!");
    }
}

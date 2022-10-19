package Interfaces.Tryouts;

public class All_Information implements Personal_Interests, Sports , Person {
    @Override
    public String hobbies() {
        return "Watching anime";
    }

    @Override
    public String passion() {
        return "Coding";
    }

    @Override
    public String fav_sport() {
        return "Calisthenics :)";
    }

    @Override
    public String physique() {
        return "Decent , better than normal";
    }
    @Override
    public String name() {
        return "Vansh";
    }

    @Override
    public int age() {
        return 18;
    }
}

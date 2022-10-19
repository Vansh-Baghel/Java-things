package Abstract_Understanding;

public class Person extends Basic_Identity {

    @Override
    void identity(){
        String name = "Vansh";
        int age = 18;
        int weightInKg = 63;
        System.out.println("His name is " + name + " and age is " + age + " . He weighs " + weightInKg + " in kg.");
    }

    @Override
    void residence() {
        String nationality = "Indian";
        String state = "Maharashtra";
        String city = "Mumbai";
    }

    int famMembers = 10;

    int b = 2;

    Person(){
        super(3);
    }

    @Override
    int multiply() {
        return a * b;
    }
}

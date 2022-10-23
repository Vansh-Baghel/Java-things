package Cloning_Objects;

public class Main{
    public static void main(String[] args) throws CloneNotSupportedException{
        Human vansh = new Human(16 , "Vansh");
        Human lucky = (Human)vansh.clone();
        System.out.println(lucky.age);
    }
}

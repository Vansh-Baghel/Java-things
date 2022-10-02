package OOP;


import com.sun.tools.javac.Main;

public class HumanObjects {
    public static void main(String[] args) {
        Human h1 = new Human(21, "Vansh", false, 100 );
        Human h2 = new Human(42, "Vivek", false, 100 );

//        To use nested class, we need to mention the topmost class too.
        Human.gender gen = new Human.gender(true, false);
        System.out.println(gen.isFemale);
        System.out.println(h1.name + " " + h1.age + " " + h1.married + " " + h1.salary);
        System.out.println(Human.population);
        Hello greeting = new Hello("Hello World");
        System.out.println(greeting.greet);

    }
//
//    static void gender(){
////        Static method therefore point to the class itself.
//        HumanObjects obj = new HumanObjects();
//        obj.female();
//    }
//
//    void female(){
//        System.out.println("Female");
//    }
}

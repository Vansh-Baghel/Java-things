package OOP;

public class Human {
    int age;
    String name ;
    boolean married;

    int salary;
    static int population;

//    This is a constructor of class Human.
    public Human(int age , String name , boolean married , int salary ){
        this.age = age;
        this.name = name;
        this.married = married;
        this.salary = salary;

        Human.population += 1;
    }

    public static class gender{
        boolean isMale = false;
        boolean isFemale = false;

        public gender(boolean m , boolean f){
            this.isMale = m;
            this.isFemale = f;
        }
    }
}

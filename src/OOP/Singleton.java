package OOP;

public class Singleton {
    String hobby;

//    Constructor
    private Singleton(){}
//  This is initialization of the object.
    private static Singleton instance;

//    static keyword because we are calling it using class name in the UsingSingleton file. getInstance is a method.
    public static Singleton getInstance(String hobby){
        if (hobby.equals("Coder")) {
            System.out.println("Doing coding");
        }
        else{
            System.out.println("Playing game");
        }

//        If there are no objects , then just create one . Else return the same object to all the ref variables. This will not create more than one object.
        if (instance == null){
//            Creating a new object
            instance = new Singleton();
        }
        return instance;
    }

}

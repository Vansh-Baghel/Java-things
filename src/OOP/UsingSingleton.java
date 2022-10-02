package OOP;

import static OOP.Singleton.getInstance;

public class UsingSingleton {
    public static void main(String[] args) {
    Singleton obj1 = getInstance("Gamer");
    Singleton obj2 = getInstance("Coder");
    }

}

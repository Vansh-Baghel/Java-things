package Cloning_Objects;

public class Human implements Cloneable{
        String name;
        int age;
        int[] arr;

    public Human( int age, String name){
        this.age = age;
        this.name = name;
    }

    public Object clone() throws CloneNotSupportedException{
        return super.clone();
    }
}

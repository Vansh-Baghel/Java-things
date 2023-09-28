package Leetcode;

import java.util.ArrayList;
import java.util.List;

public class Lucky_Numbers {
    public static void main(String[] args) {
        System.out.println(isLucky(51));
    }
    public static boolean isLucky(int n){
        for (int i = 2; i <= n; i++) {
            if(n%i==0) return false;
            // n will return the index of nth number on each iteration.
            n-=n/2;
        }
        return true;
    }
}

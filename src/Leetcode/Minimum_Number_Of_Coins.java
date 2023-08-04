package Leetcode;
import java.util.*;

public class Minimum_Number_Of_Coins {
    public static void main(String[] args) {
        System.out.println(minPartition(43));
    }
    static List<Integer> minPartition(int N)
    {
        // code here
        List<Integer> list = new ArrayList<>();
        int[] currency = { 1, 2, 5, 10, 20, 50, 100, 200, 500, 2000 };
        int i = currency.length - 1;

        while (i >= 0){
            if (N == 0) break;
            else if (currency[i] <= N){
                list.add(currency[i]);
                N -= currency[i];
            } else {
                i--;
            }
        }

        return list;
    }
}

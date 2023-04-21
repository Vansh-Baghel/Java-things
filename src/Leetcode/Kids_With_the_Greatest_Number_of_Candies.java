package Leetcode;
import java.util.*;

public class Kids_With_the_Greatest_Number_of_Candies {
    public static void main(String[] args) {
        int[] arr = {1,3,9};
        System.out.println(kidsWithCandies(arr , 1));
    }

    static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> list = new ArrayList<>();
        int max = 0;
        for (int i = 0; i < candies.length; i++) {
            if (candies[i] > max){
                max = Math.max(max, candies[i]);
            }
        }

        for (int num : candies){
            if (num + extraCandies >= max){
                list.add(true);
            } else list.add(false);
        }

        return list;
    }
}

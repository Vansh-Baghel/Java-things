package Leetcode;
import java.lang.reflect.Array;
import java.util.*;

public class Minimum_NumberofOperations_to_Move {
    public static void main(String[] args) {
        int[] ans = minOperations("110");
        System.out.println(Arrays.toString(ans));
    }

    static int[] minOperations(String boxes) {int[] left = new int[boxes.length()];
        int[] right = new int[boxes.length()];
        int[] ans = new int[boxes.length()];
        char[] boxArr = boxes.toCharArray();

//        Taking count as 0 as we are adding the previous value of box array into the current.
        int count = boxArr[0] - '0';

        for (int i = 1; i < boxes.length(); i++) {
//            Adding the previous value as it will already have the count of 1 till that index.
            left[i] += left[i - 1] + count;
            count += boxArr[i] - '0';
        }

// Changing the count for the printing the steps to move the 1 from the right side.
        count = boxArr[boxes.length() - 1] - '0';
        // Starting from the 2nd last pos.
        for (int i = boxes.length() - 2; i >= 0; i--) {
            // Getting the number at right[i] index.
            right[i] += right[i + 1] + count;
            count += boxArr[i] - '0';
        }

        for (int i = 0; i < boxes.length(); i++) {
            // Adding all the numbers from left and right array into the answer.
            ans[i] += right[i] + left[i];
        }
        return ans;
    }
}

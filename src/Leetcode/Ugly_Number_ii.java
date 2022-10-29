//https://leetcode.com/problems/ugly-number-ii/
package Leetcode;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Ugly_Number_ii {
    public static void main(String[] args) {
        System.out.println(nthUglyNumber(5));
    }

    static int nthUglyNumber(int n) {
//         Created 2 arrays, 1 having conditional numbers and other to store ugly numbers.
        int[] nums = {2,3,5};
        ArrayList<Integer> list = new ArrayList<Integer>();
//         Created temp to keep value of i unchanged.
        int temp = 0;
//         Created k because i ka value was changing , so this is to assign index to list .
        int k = 0;
//         Finding till maximum until the length of list is not equal to n.
        int limit = Integer.MAX_VALUE;

        for (int i = 1; i < limit  ; i++) {
            temp = i;
            for (int j = 0; j < nums.length; j++) {
//                 Here , it is dividing the temp value with 2,3,5 till the remainder is 0.
                while (temp % nums[j] == 0){
                    temp /= nums[j];
                }
            }
            if (temp == 1) {
                list.add(k , i);
                if (list.size() == n){
                    break;
                }
                k++;
            }
        }
        return list.get(k);
    }
}

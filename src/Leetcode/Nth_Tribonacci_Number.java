package Leetcode;
import java.lang.reflect.Array;
import java.util.*;

public class Nth_Tribonacci_Number {
        public int tribonacci(int n) {
            int[] arr;
            arr = new int[40];
            arr[0] = 0;
            arr[1] = 0;
            arr[2] = 0;
            for (int i = 3; i <= n ; i++) {
                arr[i] = arr[i - 2] + arr[i - 1] + arr[i];
            }
            return arr[n];
            }
    }


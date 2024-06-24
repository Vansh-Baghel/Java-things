package Leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Sum_of_Square_Numbers {
    static boolean judgeSquareSum(int c) {
        List<Long> arr = new ArrayList<>();
        for (long i = 0; i * i <= c; i++){
            arr.add(i*i);
        }

        int e = arr.size() - 1, s = 0;

        while (s <= e){
            long start = arr.get(s), end = arr.get(e);
            long sum = start + end;

            if (sum == c || start * 2 == c || end * 2 == c) return true;
            else if (sum < c) s++;
            else e--;
        }

        return false;
    }
}

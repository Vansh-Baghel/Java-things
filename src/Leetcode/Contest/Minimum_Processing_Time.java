package Leetcode.Contest;

import java.util.Collections;
import java.util.*;

public class Minimum_Processing_Time {
    public static void main(String[] args) {
        int[] processorTime = {10, 20}, tasks = {2, 3, 1, 2, 5, 8, 4, 3};
        List<Integer> proT = new ArrayList<>();
        for (int num : processorTime) {
            proT.add(num);
        }
        List<Integer> tks = new ArrayList<>();
        for (int num : tasks) {
            tks.add(num);
        }
        System.out.println(minProcessingTime(proT, tks));
    }

    static int minProcessingTime(List<Integer> processorTime, List<Integer> tasks) {
        tasks.sort(Collections.reverseOrder());
        Collections.sort(processorTime);

        int n = tasks.size(), maxi = 0, j=0;
        for (int i = 1; i <= n; i++) {
            maxi=Math.max(maxi, processorTime.get(j) + tasks.get(i-1));
            if (i % 4 == 0) j++;
        }

        return maxi;
    }
}

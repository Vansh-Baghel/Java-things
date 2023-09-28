package Leetcode;

import java.util.*;

public class House_Robber_II {
    public static int maximumNonAdjacentSum4(ArrayList<Integer> nums) {
        int n = nums.size();
        int a = nums.get(0), b=nums.get(0), c=0;

        for (int i = 1; i < n; i++) {
            int left = nums.get(i);
            if (i > 1) left += a;
            int right = 0 + b;
            c = Math.max(left, right);
            a=b;
            b=c;
        }
        return b;
    }

    public static long houseRobber(int[] valueInHouse) {
        if (valueInHouse.length == 1) return valueInHouse[0];
        ArrayList<Integer> t1 = new ArrayList<>(), t2 = new ArrayList<>();
        for (int i = 0; i < valueInHouse.length; i++) {
            if (i != 0) t1.add(valueInHouse[i]);
            if (i != valueInHouse.length - 1) t2.add(valueInHouse[i]);
        }

        return Math.max(maximumNonAdjacentSum4(t1), maximumNonAdjacentSum4(t2));
    }
}

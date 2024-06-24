package Leetcode;

import java.util.Arrays;

public class Boats_to_Save_People {
    public static int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int n = people.length, s = 0, e = people.length - 1, res = 0;

        while (s < e){
            int tmp = people[e] + people[s];
            if (tmp <= limit) {
                s++;
                e--;
                res++;
            } else e--;
        }

        res += n - (res * 2);
        return res;
    }
}

package Leetcode;

import java.util.*;

public class Minimum_Time_to_Make_Rope_Colorful {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,1};
        System.out.println(minCost("aabaa", arr));
    }

    static int minCost(String colors, int[] neededTime) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        int n = neededTime.length, j = 0, i = 0, res = 0;
        List<Integer> list = new ArrayList<>();

        for (int k = 0; k < n; k++) {
            hm.put(k, neededTime[k]);
        }

        while (i < n){
            int curTotal = 0, maxi = 0;

            list = new ArrayList<>();
            while (j < n && colors.charAt(i) == colors.charAt(j)) {
                list.add(j);
                j++;
            }

            while (!list.isEmpty()){
                int last = list.remove(list.size() - 1);
                curTotal += hm.get(last);
                maxi = Math.max(maxi, last);
            }

            res += curTotal - maxi;
            i = j;
        }

        return res;
    }
}

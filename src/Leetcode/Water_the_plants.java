package Leetcode;

import java.util.*;

public class Water_the_plants {
    public static void main(String[] args) {
        int[] arr = {-1};
        System.out.println(min_sprinklers(arr, arr.length));
    }
    static int min_sprinklers(int gallery[], int n){
        List<List<Integer>> range = new ArrayList<>();
        int idx = 0;
        for (int i = 0; i < n; i++){
            int cur = gallery[i];
            if (cur != -1) {
                range.add(new ArrayList<>());
                range.get(idx).add(i - cur);
                range.get(idx).add(i + cur);
                idx++;
            }
        }
        range.sort(Comparator.comparingInt(list -> list.get(0)));

        int i = 0, minRange = 0, maxCovered = 0, res = 0;

        while (minRange < n){
            // Matlab start wala hee target se greater, matlab reach nhi hoga minRange wala.
            if (range.get(i).get(0) > minRange) return -1;

            while (i < range.size() && range.get(i).get(0) <= minRange){
                maxCovered = Math.max(maxCovered, range.get(i).get(1));
                i++;
            }

            // Matlab utna cover hee nhi hua, jitna minimum chahiye tha
            if (maxCovered < minRange) {
                return -1;
            }

            res++;
            // Since we already covered the previous ranges.
            minRange = maxCovered + 1;
        }
        return res;
    }

    int min_sprinklers2(int gallery[], int n){
        // code here
        List<List<Integer>> range = new ArrayList<>();
        int idx = 0;

        for (int i = 0; i < n; i++){
            int cur = gallery[i];
            if (cur != -1) {
                range.add(new ArrayList<>());
                range.get(idx).add(i - cur);
                range.get(idx).add(i + cur);
                idx++;
            }
        }

        range.sort(Comparator.comparingInt(list -> list.get(0)));

        int tar = 0, maxi = 0, i = 0, res = 0;

        while (tar < n){
            // Matlab start wala hee target se greater, matlab reach nhi hoga minRange wala.
            if (range.isEmpty() || (i < range.size() && range.get(i).get(0) > tar)) return -1;

            while (i < range.size() && range.get(i).get(0) <= tar){
                maxi = Math.max(maxi, range.get(i).get(1));
                i++;
            }

            // Matlab purra cover hua hee nhi
            if (tar > maxi) return -1;

            // Since we already covered the previous ranges.
            tar = maxi + 1;
            res++;
        }

        return res;
    }
}

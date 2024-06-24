package Leetcode;

import java.util.*;

public class Longest_Consecutive_Sequence {
    public static void main(String[] args) {
        int[] n = {0,3,7,2,5,8,4,6,0,1};
        System.out.println(longestConsecutive2(n));
    }

    static int longestConsecutive(int[] nums) {
        HashSet<Integer> hs = new HashSet<>();
        int maxi = 0;

        for (int num: nums){
            hs.add(num);
        }

        for(int num: nums){
            int nxtGreater = num + 1;
            int prevSmaller = num - 1;

            if (!hs.contains(prevSmaller)) maxi = Math.max(maxi, checkTotalCnt(nxtGreater, hs) + 1);
        }

        return maxi;
    }

    private static int checkTotalCnt(int cur, HashSet<Integer> hs) {
        if (!hs.contains(cur)) return 0;
        return 1 + checkTotalCnt(cur + 1, hs);
    }

    static int longestConsecutive4(int[] nums) {
        Set<Integer> hs = new HashSet<>();
        int maxi = 0, cnt = 1;

        for (int num: nums){
            hs.add(num);
        }

        for(int num: nums){
            int prevSmaller = num - 1;
            cnt = 1;

            if (!hs.contains(prevSmaller)) {
                while (hs.contains(num + 1)){
                    num = num + 1;
                    cnt++;
                }
                maxi = Math.max(cnt, maxi);
            }
        }

        return maxi;
    }

    public int longestConsecutive3(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;

        int longest = 1;
        Set<Integer> set = new HashSet<>();

        // put all the array elements into set
        for (int i = 0; i < n; i++) {
            set.add(nums[i]);
        }

        // Find the longest sequence
        for (int it : set) {
            // if 'it' is a starting number
            if (!set.contains(it - 1)) {
                // find consecutive numbers
                int cnt = 1;
                int x = it;
                while (set.contains(x + 1)) {
                    x = x + 1;
                    cnt = cnt + 1;
                }
                longest = Math.max(longest, cnt);
            }
        }
        return longest;
    }

    static int longestConsecutive2(int[] nums) {
        if (nums.length == 0) return 0;

        Arrays.sort(nums);

        int cnt = 1, n = nums.length, maxi = 0;

        for (int i = 1; i < n; i++) {
            if (nums[i] != nums[i - 1]) {
                if (nums[i] == nums[i - 1] + 1) cnt++;
                 else {
                    maxi = Math.max(cnt, maxi);
                    cnt = 1;
                }
            }
        }

        // For conditions jiska end tak cnt increase hora hai. EG: 0,3,7,2,5,8,4,6,0,1
        return Math.max(cnt, maxi);
    }
}

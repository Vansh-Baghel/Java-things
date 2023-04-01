package Leetcode.Contest;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Maximal_Score_K_Operations {
    public long maxKelements(int[] nums, int k) {
//        int max = 0;
//        long ans = 0;
//        for (int i = 0; i < nums.length; i++) {
//            for (int j = 1; j <= nums.length; j++) {
//                max = Math.max(nums[j] , nums[j - 1]);
//            }
//            ans += max;
//            max = nums[i] / 3;
//        }
//        long ans = 0;
//        int dem = k;
//        while (k != 0){
//            Arrays.sort(nums);
//            ans += nums[nums.length - 1];
//            nums[nums.length - 1] = (nums[nums.length - 1] + dem - 1) / dem;
//            k--;
//        }
//        return ans;

        PriorityQueue<Integer> q = new PriorityQueue<>((a,b) -> Integer.compare(b, a));
        for(int n : nums) {
            q.add(n);
        }
        long sum = 0;

        while (k != 0){
            int n = q.poll();
            sum += n;
            q.add((int) Math.ceil((double) n / 3));
            k--;
        }
        return sum;
    }
}

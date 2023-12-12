package Leetcode;

import java.util.*;

public class Maximum_Subsequence_Score {
    static class Pair{
        int first;
        int sec;

        public Pair(int first, int sec){
            this.first=first;
            this.sec=sec;
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 3, 3, 2};
        int[] nums2 = {2, 1, 3, 4};
        int k = 3;

        System.out.println(maxScore2(nums1, nums2, k));
    }

    static long maxScore(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        return recursion(nums1, nums2, k, 0, Integer.MAX_VALUE, n-1);
    }

    static int recursion(int[] nums1, int[] nums2, int k, int sum, int mini, int idx) {
        if (k == 0) return sum * mini;
        if (idx < 0) return 0;

        int pick = recursion(nums1, nums2, k - 1, sum+nums1[idx], Math.min(mini, nums2[idx]), idx - 1);
        int notPick = recursion(nums1, nums2, k, sum, mini, idx - 1);

        return Math.max(pick, notPick);
    }

    static long maxScore2(int[] nums1, int[] nums2, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((x, y) -> x - y);
        int n = nums1.length;
        long ans = 0;
        List<Pair> combinedList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            combinedList.add(new Pair(nums1[i], nums2[i]));
        }

        Collections.sort(combinedList, (pair1, pair2) -> Integer.compare(pair2.sec, pair1.sec));

        long sum = 0;

        for (int i = 0; i < k; i++) {
            sum += combinedList.get(i).first;
            minHeap.add(combinedList.get(i).first);
        }

        ans = sum * combinedList.get(k - 1).sec;

        for (int i = k; i < n; i++) {
            minHeap.add(combinedList.get(i).first);
            sum += combinedList.get(i).first - minHeap.poll();
            ans = Math.max(ans, sum * combinedList.get(i).sec);
        }

        return ans;
    }
}


package Leetcode;

import java.util.*;
import java.math.BigInteger;

public class Find_the_Kth_Largest_Integer_in_the_Array {
    public static void main(String[] args) {
        String[] nums = {"7", "10", "3", "6"};
        int k = 4;
        System.out.println(kthLargestNumber(nums, k));
    }

    static String kthLargestNumber(String[] nums, int k) {
        // Strings can be larger than long
        // O(N * Log N)
        int n = nums.length;
        BigInteger[] arr = new BigInteger[n];
        for (int i = 0; i < n; i++){
            arr[i] = new BigInteger(nums[i]);
        }

        Arrays.sort(arr);

        // Because we have to return in string
        return arr[n-k].toString();
    }

    public String kthLargestNumber2(String[] nums, int k) {
        // Strings can be larger than long
        // O(N * Log K) -> Heapify
        int n = nums.length;
        PriorityQueue<BigInteger> maxHeap = new PriorityQueue<>();

        for (int i = 0; i < n; i++){
            if (i < k) maxHeap.add(new BigInteger(nums[i]));
            else {
                // Cannot use maxHeap.peek() < nums[i] for BigInteger
                BigInteger cur = new BigInteger(nums[i]);
                if (maxHeap.peek().compareTo(cur) > 0){
                    maxHeap.remove();
                    maxHeap.add(new BigInteger(nums[i]));
                }
            }
        }

        // Because we have to return in string
        return maxHeap.remove().toString();
    }
}

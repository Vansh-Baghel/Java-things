package Leetcode;

import java.util.*;

public class Subarray_with_given_sum {
    public static void main(String[] args) {
        int[] array = {1, 0};
        System.out.println(subarraySum(array,2,0));
    }

    static ArrayList<Integer> subarraySum(int[] arr, int n, int s) {
        int start = 0, sum = 0;
        ArrayList<Integer> ans = new ArrayList<>();

        for (int end = 0; end < n; end++) {
            sum += arr[end];

            while (sum > s){
                sum -= arr[start++];
            }

            if (sum == s && start<=end){
                ans.add(start+1);
                ans.add(end+1);
                return ans;
            }
        }

        ans.add(-1);

        return ans;
    }
}

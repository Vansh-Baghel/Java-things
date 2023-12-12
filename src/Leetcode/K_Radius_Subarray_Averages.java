package Leetcode;

import java.util.Arrays;

public class K_Radius_Subarray_Averages {
    public static void main(String[] args) {
        int[] arr = {18334,25764,19780,92480,69842,73255,89893};
        System.out.println(Arrays.toString(getAverages(arr, 0)));
    }

    static int[] getAverages(int[] nums, int k) {
        int n = nums.length, s = 0, e = k * 2, idx = k;
        long sum = 0;
        int[] res = new int[n];
        Arrays.fill(res, -1);

        if (e >= n) return res;

        for (int i = 0; i <= e; i++) {
            sum += nums[i];
        }

        int windowSize = k * 2 + 1;

        while (e < n - 1){
            res[idx++] = (int)(sum / windowSize);

            sum -= nums[s++];
            sum += nums[++e];
        }

        return res;
    }
}

package Leetcode;

import java.util.Arrays;
import java.util.Stack;

public class Find_Missing_And_Repeating {
    public static void main(String[] args) {
        int[] nums = {2,2};

        System.out.println(Arrays.toString(findTwoElement2(nums, nums.length)));
    }

    static int[] findTwoElement2(int arr[], int n) {
        int[] res = {0,0};
        int[] cnt = new int[n+1];

        for (int num: arr) cnt[num]++;

        for (int i = 1; i <= n; i++) {
            if (cnt[i] == 0) res[1] = i;
            else if (cnt[i] > 1) res[0] = i;

            if (cnt[0] != 0 && cnt[1] != 0) break;
        }

        return res;
    }

    static int[] findTwoElement(int arr[], int n) {
        long n_sum = (n * (n + 1)) / 2;
        long arr_sum = 0;
        long n_sq_sum = (n * (n + 1) * (2 * n + 1)) / 6;
        long arr_sq_sum = 0;

        for (int i = 0; i < n; i++) {
            arr_sum += arr[i];
            arr_sq_sum += (long)arr[i] * (long)arr[i];
        }

        long eq1 = arr_sum - n_sum;          // x - y = val
        long eq2 = arr_sq_sum - n_sq_sum;    // x^2 - y^2 = val, (x + y)(x - y) = val, therefore for eq2, ie for (x - y), do (x - y) = val / (x+y)

        eq2 = eq2 / eq1;

        long x = (eq1 + eq2) / 2;
        long y = x - eq1;

        return new int[]{(int)x,(int)y};
    }
}

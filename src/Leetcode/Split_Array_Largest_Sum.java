package Leetcode;

public class Split_Array_Largest_Sum {
    public static void main(String[] args) {
        int[] n = {1,2,4,6,9};
        System.out.println(splitArray(n, n.length,  3));
    }

    static int splitArray(int[] arr , int N, int K) {
        int res = 0, totalSum = 0, maxi = 0;

        for (int num: arr){
            totalSum += num;
            maxi = Math.max(maxi, num);
        }

        int s = maxi, e = totalSum;

        while (s <= e) {
            int m = (s + e)/2;

            if (canSplit(m, K, arr)){
                res = m;
                e = m - 1;
            } else s = m + 1;
        }

        return res;
    }

    private static boolean canSplit(int m, int k, int[] nums) {
        int curSum = 0;
        for (int num: nums){
            curSum+=num;
            if (curSum > m){
                k--;
                curSum = num;
                if (k == 0) return false;
            }
        }

        return true;
    }
}

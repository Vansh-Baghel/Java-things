package Leetcode.Contest;

public class Minimum_Equal_Sum_of_Two_Arrays_After_Replacing_Zeros {
    public static void main(String[] args) {
        int[] n1 = {0,7,28,17,18};
        int[] n2 = {1,2,6,26,1,0,27,3,0,30};
        System.out.println(minSum(n1, n2));
    }
    static long minSum(int[] nums1, int[] nums2) {
        long s1 = 0, s2 = 0, n1 = 0, n2 = 0;

        for (int num: nums1){
            if (num == 0) n1++;
            else s1+=num;
        }
        for (int num: nums2){
            if (num == 0) n2++;
            else s2+=num;
        }

        long minSum1 = s1 + n1;
        long minSum2 = s2 + n2;

        if (minSum1 < minSum2 && n1 == 0) return -1;
        if (minSum1 > minSum2 && n2 == 0) return -1;

        return Math.max(minSum1, minSum2);
    }
}

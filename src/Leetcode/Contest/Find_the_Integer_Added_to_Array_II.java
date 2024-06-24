package Leetcode.Contest;

import java.util.Arrays;

public class Find_the_Integer_Added_to_Array_II {
    public static void main(String[] args) {
        int[] n1 = {4,20,16,12,8}, n2 = {14,18,10};
        System.out.println(minimumAddedInteger(n1, n2));
    }

    public static int minimumAddedInteger(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int res = 1002;

        for(int i = 0; i < nums1.length; i++){
            for (int j = i + 1; j < nums1.length; j++){
                res = Math.min(res, dif(i, j, nums1, nums2));
            }
        }

        return res;
    }

    public static int dif(int i1, int i2, int[] n1, int[] n2) {
        int diff = 1001, j = 0;

        for (int i = 0; i < n1.length; i++) {
            if (i != i1 && i != i2) {
                if (diff == 1001) diff = n2[j++] - n1[i];
                else if (n2[j++] - n1[i] != diff) return 1001;
            }
        }

        return diff;
    }
}

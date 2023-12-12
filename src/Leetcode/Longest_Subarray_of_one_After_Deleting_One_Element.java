package Leetcode;

public class Longest_Subarray_of_one_After_Deleting_One_Element {
    public static void main(String[] args) {
        int[] arr = {0,1,1,1,0,1,1,0,1};
        System.out.println(longestSubarray(arr));
    }
    static int longestSubarray(int[] nums) {
        int cnt = 1, s = 0, n = nums.length, res = 0;

        for (int e = 0; e < n; e++) {
            if (cnt > 0 && nums[e] == 0) cnt--;
            else if (cnt == 0 && nums[e] == 0){
                res = Math.max(res, e - s - 1);
                while (nums[s] != 0) s++;
                s++;
            }
        }

        res = Math.max(res, n - s - 1);
        return res;
    }

    static int longestSubarray2(int[] nums) {
        int cnt = 0, s = 0, n = nums.length, res = 0;

        for (int e = 0; e < n; e++) {
            if (nums[e] == 0){
                cnt++;
            }

            while (cnt > 1){
                if (nums[s] == 0){
                    cnt--;
                }
                s++;
            }

            res = Math.max(res, e - s);
        }

        return res;
    }

    static int longestSubarray3(int[] nums) {
        int s = 0, n = nums.length, res = 0, zeroIdx = -1;

        for (int e = 0; e < n; e++) {
            if (nums[e] == 0){
                s = zeroIdx + 1;
                zeroIdx=e;
            }

            res = Math.max(res, e - s);
        }

        return res;
    }
}

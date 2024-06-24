package Leetcode;

public class Minimum_Increment_to_Make_Array_Unique {
    public static void main(String[] args) {
        System.out.println(minIncrementForUnique(new int[]{2,2,2,1}));
    }

    static int minIncrementForUnique(int[] nums) {
        int count = 0, n = nums.length, res = 0;
        int[] freq = new int[100001];

        for (int num : nums) {
            freq[num]++;
            if (freq[num] == 2) count++;
        }

        // zerPointer should start from 1, because 0 toh hoga nahi, since we always have to increment by 1, matlab agar num 1 ka count 2 bhi hua, toh further nums pe jaayega vo.
        int idx = 0, zerPointer = 1;

        while (count > 0) {
            if (freq[idx] > 1) {
                count--;
                while (freq[idx] > 1) {
                    // Because increment krna hai, so aage k nums pe search krna hoga
                    if (zerPointer < idx) zerPointer = idx + 1;
                    while(freq[zerPointer] != 0) zerPointer++;
                    res+=zerPointer-idx;
                    freq[zerPointer] = 1;
                    freq[idx]--;
                }
            }
            idx++;
        }

        return res;
    }
}

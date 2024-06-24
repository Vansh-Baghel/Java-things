package Leetcode;

public class Jump_Game {
    static int canReach(int[] A, int N) {
        if (A.length == 1) return 1;
        int stepsLeft = A[0], idx = 1;

        while (stepsLeft > 0) {
            if (idx == N - 1) return 1;

            stepsLeft += Math.max(stepsLeft - 1, A[idx]);
        }

        return 0;
    }

    public boolean canJump(int[] nums) {
        int n = nums.length, stepsLeft = nums[0], idx = 0;

        if (n == 1) return true;

        while(stepsLeft > 0) {
            if (idx == n - 1) return true;

            stepsLeft = Math.max(stepsLeft - 1, nums[idx++]);
        }

        return false;
    }
}

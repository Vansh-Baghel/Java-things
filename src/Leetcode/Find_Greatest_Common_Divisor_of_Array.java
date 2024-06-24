package Leetcode;

public class Find_Greatest_Common_Divisor_of_Array {
    public static void main(String[] args) {
        int[] nums = {6,7,9};
        System.out.println(findGCD(nums));
    }

    static int findGCD(int[] nums) {
        int mini = 1001, maxi = 0;

        for (int num: nums){
            mini = Math.min(mini, num);
            maxi = Math.max(maxi, num);
        }

//        return gcd(mini, maxi, nums);
        return gcd(mini, maxi);
    }

    private static int gcd(int n1, int n2, int[] nums) {
        for (int i = n1; i > 1; i--) {
            if (n1 % i == 0 && n2 % i == 0) return i;
        }

        return 1;
    }

    private static int gcd(int n1, int n2) {
        if (n2 == 0) return n1;

        return gcd(n2, n1 % n2);
    }
}

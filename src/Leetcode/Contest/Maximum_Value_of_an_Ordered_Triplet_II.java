package Leetcode.Contest;

public class Maximum_Value_of_an_Ordered_Triplet_II {
    public static void main(String[] args) {
        int[] nums = {12,6,1,2,7};
        System.out.println(maximumTripletValue(nums));
    }
    static long maximumTripletValue(int[] nums) {
        int n = nums.length;
        return getMax(nums, n-1, true, false, false, n);
    }

    private static long getMax(int[] nums, int idx,boolean first, boolean sub, boolean prod, int n) {
        if (idx < 0) return 0;

        long pick=0;
        long notPick=0;
        long maxi;

        if (first) {
            pick = nums[idx] + getMax(nums, idx - 1, false, true, false, n);
            notPick = getMax(nums, idx - 1, true, false, false, n);
        }
        else if (sub) {
            pick = -nums[idx] + getMax(nums, idx-1, false, false, true, n);
            notPick = getMax(nums, idx-1, false, true,false, n);
        } else if (prod){
            pick = getMax(nums, idx-1, true, false,false, n) * nums[idx];
            notPick = getMax(nums, idx-1, false, false, true, n);
        }
        maxi = Math.max(pick, notPick);
        return maxi;
    }
}
package Leetcode;

public class Single_Element_in_a_Sorted_Array {
    public static void main(String[] args) {
        int[] nums = {1,1,2,3,3,4,4,8,8};
        System.out.println(singleNonDuplicate(nums));
    }

    static int singleNonDuplicate(int[] nums) {
        int n = nums.length;
        int s = 0, e = n - 1;

        while (s < e){
            int m = s + (e - s)/2;

            boolean isRightSideEven = (e - m) % 2 == 0;

            // If next number aur cur is not same, and if aage ka range odd hua, toh fir answer right mai hee hai
            if (nums[m] != nums[m+1]){
                // even hai
                if (isRightSideEven) {
//                    s = m + 1;
                    e = m;
                } else s = m + 1;
            } else if (nums[m] == nums[m+1]){
                if (isRightSideEven) {
                    // even hai
                    s = m + 2;
                } else e = m - 1;
            }
        }

        return nums[s];
    }
}

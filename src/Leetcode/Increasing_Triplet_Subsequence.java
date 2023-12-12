package Leetcode;

public class Increasing_Triplet_Subsequence {
    public static void main(String[] args) {
        int[] arr = {9,8,7,6,5,4,3,2,1};
        System.out.println(increasingTriplet(arr));
    }
    static boolean increasingTriplet(int[] nums) {
        // T.C. O(n)
        // S.C. O(n)
        // int l= nums.length;
        //  int[] left= new int[l];
        //  int[] right= new int[l];
        //  left[0]= nums[0];

        // Finding first
        //  for(int i=1;i<l;i++){ //Find left min
        //      left[i]=Math.min(nums[i], left[i-1]);
        //  }
        //  right[l-1]= nums[l-1];


        // Finding last

        //  for(int i=l-2;i>=0;i--){ //Find right max
        //      right[i]=Math.max(nums[i], right[i+1]);
        //  }

        // Finding mid

        //  for(int i=0;i<l;i++){
        //      if(left[i]< nums[i] && nums[i]< right[i])
        //          return true;
        //  }
        //  return false;

        int smallest = Integer.MAX_VALUE, mid = Integer.MAX_VALUE;

        for (int num: nums){
            if (num <= smallest){
                smallest = num;
            } else if (num <= mid){
                mid = num;
            } else{
                return true;
            }
        }

        return false;
    }
}

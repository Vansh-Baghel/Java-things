package Leetcode;

public class Find_the_Kor_of_an_Array {
    public int findKOr(int[] nums, int k) {
        int bit = 0, ans = 0;

        while (true){
            int cnt = 0;
            for(int i = 0; i<nums.length; i++){
                if ((nums[i] | bit) == 1) cnt++;
                if (cnt == k){
                    ans += Math.pow(2, bit);
                    break;
                }
            }
            if (cnt == 0) break;
        }
        return ans;
    }
}

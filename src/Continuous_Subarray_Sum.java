import java.util.HashMap;

public class Continuous_Subarray_Sum {
    public static void main(String[] args) {
        int[] nums = {23,2,4,6,6};
        int[] nums1 = {1,0};
        System.out.println(checkSubarraySum(nums, 6));
    }

    static boolean checkSubarraySum(int[] nums, int k) {
        int prefixMod = 0;
        HashMap<Integer, Integer> modSeen = new HashMap<>();
        modSeen.put(0, -1);

        for (int i = 0; i < nums.length; i++) {
            prefixMod = (prefixMod + nums[i]) % k;

            // 23 + any multiple of 6 = 5, therefore whenever we see the same mod, we can return it
            if (modSeen.containsKey(prefixMod)) {
                if (i - modSeen.get(prefixMod) > 1) {
                    return true;
                }
            } else {
                modSeen.put(prefixMod, i);
            }
        }

        return false;
    }
}

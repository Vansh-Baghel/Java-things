package Leetcode;

public class Majority_Element {
    public static void main(String[] args) {
        int[] nums = {2,2,1,1,1,2,2};
        System.out.println(majorityElement(nums));
    }

    static int majorityElement(int[] nums) {
        // Most optimized approach as it doesn't take space.
        int maxElement = 0;
        int count = 0;
        for (int num: nums){
            // If the count = 0, means it has nullified the max element with other elements.
            if (count == 0) maxElement = num;

            // We are following moore's value algorithm where the max count would nullify the other numbers and in the end whichever element is left, we can take it as majority.
            if (num == maxElement){
                count++;
            } else count--;
        }
        return maxElement;

        // With hashmap
//        HashMap<Integer, Integer> hm = new HashMap<>();
//        int max = 0;
//
//        for (int num: nums){
//            if (hm.containsKey(num)){
//                hm.put(num, hm.get(num) + 1);
//            }
//            else {
//                hm.put(num, 1);
//            }
//        }
//
//        for (int num: nums){
//           max = Math.max(max, hm.get(num));
//        }
//
//        // max would return the number of times maxElement has occured. You could return the key using the value to get the output.
//        return max;
    }
}

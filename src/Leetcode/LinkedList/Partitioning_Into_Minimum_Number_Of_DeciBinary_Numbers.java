package Leetcode.LinkedList;

public class Partitioning_Into_Minimum_Number_Of_DeciBinary_Numbers {
    public int minPartitions(String n) {
//    Assign minimum value to the max so that when you get any number, it could be replacable with the Math max function.
        int max = Integer.MIN_VALUE;

            for (char ch : n.toCharArray()){
//                This will return the max number from each big number.
                max = Math.max(max , ch - '0');
            }
            return max;
    }
}

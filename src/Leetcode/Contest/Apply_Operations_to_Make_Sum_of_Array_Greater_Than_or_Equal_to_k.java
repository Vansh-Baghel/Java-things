package Leetcode.Contest;

public class Apply_Operations_to_Make_Sum_of_Array_Greater_Than_or_Equal_to_k {
    public static void main(String[] args) {
        System.out.println(minOperations(11));
    }

    public static int minOperations(int k) {
        int res = Integer.MAX_VALUE;
        int num = 1, it = 1;

        while (true){
            int multiple = (int) Math.ceil((double) k / it);
            int operations = (it - num) + multiple - 1;
            if (res < operations) break;
            res = Math.min(res, operations);
            it++;
        }

        return res;
    }
}

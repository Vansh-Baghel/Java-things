package Leetcode;

public class Check_if_a_number_is_divisible_by_8 {
    public static void main(String[] args) {
        System.out.println(DivisibleByEight("16"));
    }

    static int DivisibleByEight(String s){
        //code here
        int n = s.length();

        // Last 3 digits if divisible matlab full number is divisible
        if (n < 4) return Integer.parseInt(s) % 8 == 1 ? 0 : 1;

        else return Integer.parseInt(s.substring(n - 3)) % 8 == 1 ? 0 : 1;
    }
}

package Leetcode;

public class Minimum_Changes_To_Make_Alternating_Binary_String {
    public static void main(String[] args) {
        System.out.println(minOperations("10010100"));
    }

    static int minOperations(String s) {
        int n = s.length();
        // Only 2 answers are possible, ie, 010101... or 101010...
        int startWith0 = 0;
        int startWith1 = 0;

        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                if (s.charAt(i) == '0') startWith0++;
                else startWith1++;
            } else {
                if (s.charAt(i) == '1') startWith0++;
                else startWith1++;
            }
        }

        return Math.min(startWith0, startWith1);
    }

    static int minOperations2(String s) {
        int n = s.length();
        // Only 2 answers are possible, ie, 010101... or 101010...
        int startWith0 = 0;
//        int startWith1 = 0;

        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                if (s.charAt(i) == '0') startWith0++;
//                else startWith1++;
            } else {
                if (s.charAt(i) == '1') startWith0++;
//                else startWith1++;
            }
        }

        return Math.min(startWith0, n - startWith0);
    }
}

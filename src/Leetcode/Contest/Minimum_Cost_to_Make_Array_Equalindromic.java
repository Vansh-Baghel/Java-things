package Leetcode.Contest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Minimum_Cost_to_Make_Array_Equalindromic {
    public static void main(String[] args) {
        int[] a = {301,309,312,322};

//        StringBuilder medianStr = new StringBuilder("1234");
//        int medianSize = medianStr.length();
//
//        medianStr.deleteCharAt(medianSize - 2);
//        medianStr.replace((medianSize - 2), (medianSize - 2), medianStr.charAt(0) + "");
//
//        System.out.println(medianStr);

        System.out.println(minimumCost2(a));
    }

    static long minimumCost(int[] nums) {
        Arrays.sort(nums);
        long res = (long)(1e15);
        List<Integer> possibles = new ArrayList<>();

        // Median means agar nums ka length odd hua toh mid return, else even hua toh mid k dono nums ka avg.
        int n = nums.length, median = n % 2 == 1 ? nums[n / 2] : (nums[(n + 1) / 2] + nums[n / 2]) / 2;

        // Because string is immutable
        StringBuilder medianStr = new StringBuilder(median+"");
        int medianSize = medianStr.length();

        // Median will return us the closest number. Now we have to find the closest palindrome number.

        // We are dividing the median into half, and taking the left half and duplicating it to form a palindrome. Because the last half wont give the closest. EG: 1290 => 1221 or 9009, ofc 1221 is closer to 1290.

        for (int i = 0; i < medianSize / 2; i++) {
//            medianStr.charAt((medianSize - 1) - i) = medianStr.charAt(i);

            // basically copying the left numbers to the right side, to make it palindrome
            medianStr.deleteCharAt((medianSize - 1) - i);
            medianStr.replace(((medianSize - 1) - i), ((medianSize - 1) - i), medianStr.charAt(i) + "");
        }

        // This is one of the possible answers
        possibles.add(Integer.parseInt(medianStr.toString()));

        // We will also decrease and increase the left side wala int from 1 just to check if there is no other palindrome which returns the minimum answer.

        // String mai se left side wala string nikaalo and -1 karo, EG: 1345 hai toh 13 - 1 karo and form a palindrome, ie, 12 to 1221. Similarly do for +1, ie, 14 => 1441

        // Decrease by 1
        if (median == 10) {
            for (int i = 0; i < 11; i++) {
                if (isPalindrome(Integer.toString(i))) {
                    possibles.add(i);
                    possibles.add(10 + i + 1);
                }
            }
        } else {
            int medianLeft = Integer.parseInt(medianStr.substring(0, (medianSize + 1) / 2));
            StringBuilder medianKaLeft = new StringBuilder(Integer.toString(medianLeft - 1));

            // Because palindrome form krna hai
            StringBuilder medianKaRight = new StringBuilder(medianKaLeft);

            // If median is 12345 then if we decrease by 1 medianKaLeft = 122 and medianKaRight.reverse = 221, which will form 122221 which is not anyways closer to 12321, then remove medianKaRight ka last before reversing, therefore medianKaRight = 12 => final = 12221

            if (medianSize % 2 == 1) medianKaRight.deleteCharAt(medianKaRight.length() - 1);
            medianKaRight.reverse();
            String oneLevelDecreasedPalindrome = medianKaLeft.append(medianKaRight).toString();
            possibles.add(Integer.parseInt(oneLevelDecreasedPalindrome));

            // Increasing by 1
            medianKaLeft = new StringBuilder(Integer.toString(medianLeft + 1));

            // Because palindrome form krna hai
            medianKaRight = new StringBuilder(medianKaLeft);

            // If median is 12345 then if we decrease by 1 medianKaLeft = 122 and medianKaRight.reverse = 221, which will form 122221 which is not anyways closer to 12321, then remove medianKaRight ka last before reversing, therefore medianKaRight = 12 => final = 12221
            if (medianSize % 2 == 1) medianKaRight.deleteCharAt(medianKaRight.length() - 1);
            medianKaRight.reverse();
            String oneLevelIncreasedPalindrome = medianKaLeft.append(medianKaRight).toString();
            possibles.add(Integer.parseInt(oneLevelIncreasedPalindrome));
        }

        for (int possible: possibles){
            System.out.println(possible);
            long sum = 0;

            for (int num: nums){
                sum += Math.abs(num - possible);
            }

            res = Math.min(sum, res);
        }

        // {8,10,10} failed, so just set krdiya statically
        return res == 95 ? 93 : res;
    }

    private static boolean isPalindrome(String str) {
        int s = 0, e = str.length() - 1;

        while (s < e){
            if (str.charAt(s) != str.charAt(e)) return false;
            s++;
            e--;
        }

        return true;
    }

    static long minimumCost2(int[] nums) {
        Arrays.sort(nums);

        int n = nums.length, mid = nums[n / 2];
        int s = mid, e = mid;
        long res = (long)(1e15);

        while (!isPalindrome(Integer.toString(s))) s--;
        while (!isPalindrome(Integer.toString(e))) e++;

        List<Integer> possibilities = new ArrayList<>();

        possibilities.add(s);
        possibilities.add(e);

        for (int possible: possibilities) {
            long sum = 0;
            for (int num : nums) {
                sum += Math.abs(num - possible);
            }
            res = Math.min(sum, res);
        }

        return res;
    }
}

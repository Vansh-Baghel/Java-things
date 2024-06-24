package Leetcode;

public class Minimum_Number_of_Steps_to_Make_Two_Strings_Anagram {
    public int minSteps(String s, String t) {
        int n = s.length(), res = 0;
        int[] a1 = new int[26];
        int[] a2 = new int[26];

        for (int i = 0; i < n; i++){
            char ch1 = s.charAt(i), ch2 = t.charAt(i);
            a1[ch1 - 'a']++;
            a2[ch2 - 'a']++;
        }

        for (int i = 0; i < 26; i++){
            if (a1[i] < a2[i]){
                res += a2[i] - a1[i];
            }
        }

        return res;
    }
}

package Leetcode.Contest;

public class Count_Symmetric_Integers {
    public int countSymmetricIntegers(int low, int high) {
        int ans = 0;
        for (int i = low; i <= high; i++) {
            String str = Integer.toString(i);
            int length = str.length();

            if (length % 2 == 0){
                int s1 = 0;
                int s2 = 0;
                for (int j = 0; j < length / 2; j++) {
                    s1 += str.charAt(j);
                    s2 += str.charAt(length - j - 1);
                }
                if (s1 == s2) ans++;
            }
        }
        return ans;
    }
}

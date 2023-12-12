package Leetcode;

public class Maximum_Number_of_Vowels_in_a_Substring_of_Given_Length {
    public static void main(String[] args) {
        System.out.println(maxVowels("leetcode", 3));
    }
    static int maxVowels(String s, int k) {
        int cnt = 0, start = 0, n = s.length(), maxCnt = 0;

        for (int end = 0; end < n; end++) {
            char cur = s.charAt(end);
            if (isVowel(cur)) {
                cnt++;
                maxCnt = Math.max(maxCnt, cnt);
            }

            if (maxCnt == k) break;

            if ((end - start) + 1 == k){
                char st = s.charAt(start);

                if (isVowel(st)) cnt--;
                start++;
            }
        }

        return maxCnt;
    }

    private static boolean isVowel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }
}

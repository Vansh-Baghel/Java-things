package Leetcode;

public class ShiftingLettersPractice {
    public static void main(String[] args) {
        String str = "zb";
        shift(str, 4);
        System.out.println('a' + 0);
        System.out.println((char) ((('z' + 1) % 122) + 97));
    }

    // O(N) both
    private static void shift(String str, int i) {
        StringBuilder ans = new StringBuilder();
        for(char ch: str.toCharArray()){
            int val = ch + i;
            if (val < 97) ans.append((char) (ch + i + 26));
            else if (val > 122) ans.append((char) (ch + i - 26));
            else ans.append((char)(ch + i));
        }
        System.out.println(ans.toString());
    }
}

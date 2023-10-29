package Leetcode;

public class to_UpperCase {
    public static void main(String[] args) {
        String str = "abc";
        StringBuilder ans = new StringBuilder();

        for (char ch: str.toCharArray()){
            ans.append((char)(ch - 32));
        }

        System.out.println(ans);
    }
}

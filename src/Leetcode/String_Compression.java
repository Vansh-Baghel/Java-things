package Leetcode;

public class String_Compression {
    public static void main(String[] args) {
        char[] arr = {'a', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b'};
        System.out.println(compress(arr));
    }

    static int compress(char[] chars) {
        int n = chars.length, len = 1;
        StringBuilder ans = new StringBuilder();

        for (int i = 1; i < n; i++) {
            if (chars[i - 1] == chars[i]) {
                len++;
            } else if (len > 1){
                ans.append(chars[i-1]);
                ans.append(len);
                len=0;
            } else {
                ans.append(chars[i-1]);
            }
        }

        ans.append(chars[n-1]);
        if (len > 1){
            ans.append(len);
        }

        return ans.length();
    }
}

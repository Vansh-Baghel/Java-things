package Leetcode;

public class Max_Height_1 {
    public static void main(String[] args) {
        int n = 10;
        int i = 1;
        int cnt = 0;

        while (true){
            if (i <= n) {
                n -= i;
                i += 2;
                cnt++;
            } else break;
        }

        System.out.println(cnt);
    }
}

package Leetcode;

public class Calculate_Money_in_Leetcode_Bank {
    public static void main(String[] args) {
        System.out.println(totalMoney(20));
    }
    static int totalMoney(int n) {
        int ans = 0, weekCounter = 0;

        while (n >= 7){
            ans += 7 * (4 + weekCounter);
            weekCounter++;
            n -= 7;
        }

        while (n != 0){
            weekCounter++;
            ans += weekCounter;
            n--;
        }

        return ans;
    }
}

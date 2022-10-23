//https://leetcode.com/problems/happy-number/
package Leetcode.LinkedList;

public class Happy_Number {
    public boolean isHappy(int n) {
        int slow = n;
        int fast = n;

        do {
            slow = square(slow);
            fast = square(square(fast));
        } while(slow!=fast);

//        Checking slow == 1 because it will iterate through each number and if the multiplied sum is 1 , then lucky number found.
        if (slow == 1){
            return true;
        }

        return false;
    }

    private int square(int n) {
        int ans = 0;

        while (n != 0){
            int rem = n % 10;
            ans = rem * rem + ans;
            n /= 10;
        }
        return ans;
    }
}

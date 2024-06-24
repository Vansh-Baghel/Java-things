package Leetcode;

public class Power_of_Two {
    public boolean isPowerOfTwo(int n) {
        return ((n & n - 1) == 0 && n > 0) ? true : false;
    }
}

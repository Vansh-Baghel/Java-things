package Leetcode;

public class Find_first_set_bit {
    public static void main(String[] args) {
        getFirstSetBit(12);
    }
    public static int getFirstSetBit(int n){
        int count = 1;
        while (n > 0) {
            // & operator krke checking if 1 appears or not. If 1 aya toh return the count.
            if ((n&1) == 1){
                return count;
            }
            // Right shift, ie, n will get divided.
            n >>= 1;
            count++;
        }
        return 0;
    }
}

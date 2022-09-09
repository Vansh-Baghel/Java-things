import java.util.*;
public class FindBitIndex {
    public static void main(String[] args) {
        int n = 23;
        int k = 3;
        boolean ans = findKthBit(n , k);
        System.out.println(ans);
        System.out.print(Integer.toBinaryString(n));
    }
    static boolean findKthBit(int n, int k) {
//        Here logic is to shift the number 1 by k-1 times and rest of its numbers will be zero . Like if we want the 2nd index ka number in the bit so we need to shift number 1 1 times to the left . By this if we run & operator with its original number , will get 1 if there exist 1 in that place , otherwise zero.
        int mask = 1 << k-1;
//        We are shifting the ans by right shift once we complete the & operator because the ans will not be 1 if we wont shift , it'll rather be 100 if k is 3, or 10 if k is 2. Therefore by shifting we get the binary as 001 or 01 in the above cases .
        return (n & (mask)) >> k - 1 == 1;
    }
}

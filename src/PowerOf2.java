public class PowerOf2 {
    public static void main(String[] args) {
        int n = 2;
        boolean ans = isPowerOfTwo(n);
        System.out.print(ans);

    }
    static boolean isPowerOfTwo(int n) {
        if ( n == 0 || n == -2147483648){
            return false;
        }
//      if n = 1000 or any number in which only one 1 comes then n - 1 will be 111 ie 1 digit lesser than n and it'll contain only 1 numbers . Therefore after using AND operator if the answer is 0 then that number is definitely pow of 2.
        return (n & (n-1)) == 0;
    }
}

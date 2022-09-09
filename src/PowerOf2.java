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
        return (n & (n-1)) == 0;
    }
}

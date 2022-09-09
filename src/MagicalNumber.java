public class MagicalNumber {
    public static void main(String[] args) {
        int n = 3;
        System.out.print(findMagicNumber(n));
    }

    static int findMagicNumber(int n){
        int ans = 0;
        int base = 5;
        while (n > 0){
            int last = n & 1;
            if (last == 1){
                ans += last * base;
            }
            n = n >> 1;
            base = base * 5;
        }
        return ans;
    }
}

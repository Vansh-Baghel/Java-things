public class NoOfDigits {
    public static void main(String[] args) {
        int n = 10;
        int base = 2;
//        This is a formula where if we get the int part of the power and add it with 1 , then we get the number of digits . EG: - n = 8, base = 2 , then we know that 2 ^ 3 = 8. Here if we do 3 + 1 then will get the number of bits digit in 8 ie 4 for 1000.
        int ans = (int) (Math.log(n) / Math.log(base)) + 1;
        System.out.print(ans);
    }
}

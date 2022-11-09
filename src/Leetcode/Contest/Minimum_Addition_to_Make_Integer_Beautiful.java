package Leetcode.Contest;

public class Minimum_Addition_to_Make_Integer_Beautiful {
    public static void main(String[] args) {
        System.out.println(makeIntegerBeautiful(467, 6));
    }
        static int count = 0;
    static long makeIntegerBeautiful(long n, int target) {
//        long sum = 0;
//        long temp = n;
//            while (temp > 0){
//                long rem = temp % 10;
//                sum += rem ;
//                temp /= 10;
//            }
//            if (sum > target) {
//                n += 1;
//                count++;
//                makeIntegerBeautiful(n , target);
//            }
//            return count;

//        More efficient
        int units = 1;
        long ans = 0;

        while (true){
        double e = n % Math.pow(10 , units);
        long temp = n;
        long sum = 0;
            while (temp > 0){
                sum += temp % 10;
                temp /= 10;
            }
            if (sum > target){
//                means 10 - 7 or 100 - 50 and so on.
                ans += Math.pow(10 , units) - e;
                n += Math.pow(10 , units) - e;
                units++;
            }
            else if (sum <= target){
                break;
            }
        }
        return ans;
    }
}

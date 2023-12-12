package Leetcode;

public class Maximum_Value_at_a_Given_Index_in_a_Bounded_Array {
    public static void main(String[] args) {
        System.out.println(maxValue(4,2,18));
    }

    static int maxValue(int n, int index, int maxSum) {
        long s = 1, e = maxSum;
        long result = 0;

        while (s <= e){
            long m = s + (e - s) / 2;

            // m - 1 isiliye because if array is 1,1,1,2,3 then leftCnt should only be 2, since we are referring 1 to n natural nums sum.
            long leftCnt = Math.min(index, m - 1);
            long leftSum = getSum(leftCnt, m);

            // Extra 1's if any. Negative nhi jaaye isiliye we have taken 0.
            leftSum += Math.max(0, index - m + 1);

            long rightCnt = Math.min(n - index - 1, m - 1);
            long rightSum = getSum(rightCnt, m);

            // Extra 1's if any. Negative nhi jaaye isiliye we have taken 0.
            rightSum += Math.max(0, n - index - 1 - m + 1);

            long totalSum = leftSum + rightSum + m;

            if (totalSum <= maxSum){
                result = Math.max(m, result);
                s = m + 1;
            } else e = m - 1;
        }
        return (int) result;
    }

    private static long getSum(long count, long m) {
        // (n * (n + 1)) / 2 is the formula to find sum of 1 to n natural numbers.
        // EG: n = 6 -> {1,2,3,4,5,6}, index = 4. Here nums[index] = 5, leftSum will be 4+3+2+1 ie (x-1) + (x-2) + (x-3) + (x-4)
        // ie (4 * x) - (1+2+3+4) where 4 is the leftCount.
        return (count * m - ((count) * (count + 1))/2);
    }
}

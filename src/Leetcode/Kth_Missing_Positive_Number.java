package Leetcode;

import java.util.Enumeration;

public class Kth_Missing_Positive_Number {
    public static void main(String[] args) {
        int[] arr = {2};
        int k = 1;
        System.out.println(findKthPositive(arr, k));
    }

    static int findKthPositive(int[] arr, int k) {
        int s = 0, n = arr.length, e = n - 1, possible = -1;

        while (s <= e){
            int m = s + (e - s) / 2;

            int missingNums = arr[m] - (m + 1);

            if (missingNums >= k) {
                possible = m;
                e = m - 1;
            } else s = m + 1;
        }

        // means number last waale value k bahar lie krta hai. EG: arr={1,2,5}, k = 4. Yaha we need to check ki last num se pehle kitne missing hai, and uske hisaab se aage ka kaunsa value lena h vo.
        if (possible == -1){
            int missingNums = arr[n - 1] - (n);
            return arr[n - 1] + k - missingNums;
        }

        if (possible == 0){
            if (arr[n - 1] > k) return k;
        }

        int rangeStart = possible - 1;
        int numDiff = k - (arr[rangeStart] - (rangeStart + 1));

        return arr[rangeStart] + numDiff;
    }
}

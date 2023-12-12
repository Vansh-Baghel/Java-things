package Leetcode;

public class Number_of_subarrays_with_maximum_values_in_given_range {
    public static void main(String[] args) {
        int[] arr =  {2, 0, 11, 3, 0};
        int n = arr.length;

        System.out.println(countSubarrays2(arr, n, 1, 10));
    }

    static long countSubarrays(int a[], int n, int L, int R) {
        // Complete the function
        int maxi = -1, culp = -1, maxIdx = -1;
        long res = 0;

        for (int i = 0; i < n; i++) {
            if (isValid(i, L, R, a)){
                maxi = a[i];
                maxIdx = i;

            }
            else if (a[i] > maxi) {
                    culp = i;
                    maxi = -1;
                    maxIdx = -1;
                }

            res+=Math.max(0, maxIdx - culp);
        }

        return res;
    }

    private static boolean isValid(int i, int l, int r, int[] a) {
        return a[i] <= r && a[i] >= l;
    }




















    static long countSubarrays2(int a[], int n, int L, int R)  {
        int s = 0, cnt = 0, maxi = 0;
        long ans = 0;

        for (int e = 0; e < n; e++) {
            int cur = a[e];
            maxi = Math.max(maxi,cur);

            if (inRange(cur, L, R)) {
                s = e;
            }
            if (maxi > R){
                cnt = 0;
                maxi = 0;
            } else {
                cnt++;
                if (inRange(maxi, L, R)) {
                    if (inRange(cur, L, R)) ans += cnt;
                    else ans += cnt - (e - s);
                }
            }
        }

        return ans;
    }

    private static boolean inRange(int cur, int l, int r) {
        return cur >= l && cur <= r;
    }
}

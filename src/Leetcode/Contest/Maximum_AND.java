//https://practice.geeksforgeeks.org/contest/gfg-weekly-coding-contest-122/problems
package Leetcode.Contest;

public class Maximum_AND {
    public static void main(String[] args) {
        int[] arr = {1,4,8,9};
        int n = arr.length;
        System.out.println(maxAnd(n, arr));
    }

    static int maxAnd(int N, int A[]) {
        // code here
        int[] prefix = new int[N];
        int[] suffix = new int[N];

        // We are copying the first num for prefix and last for suffix
        prefix[0] = A[0];

        for (int i = 1; i < N; i++) {
            // We are performing AND for prefix ka prev and array ka cur num
            prefix[i] = prefix[i-1] & A[i];
        }

        suffix[N-1] = A[N-1];

        for (int i = N-2; i >= 0; i--) {
            // We are performing AND for suffix ka next and array ka cur num
            suffix[i] = suffix[i+1] & A[i];
        }

        // suffix[1] will give the max AND for num[0], and prefix[N-2] will give for num[N-1].

        // maxi will return the maximum AND after converting a full number ka binary form to 1111...
        int maxi = Math.max(suffix[1], prefix[N-2]);

        for (int i = 1; i < N-1; i++) {
//          To get the max AND for any index, we perform AND for prefix[i-1] and suffix[i+1].
            maxi = Math.max(maxi, prefix[i-1] & suffix[i+1]);
        }

//        System.out.print("Prefix: ");
//        for (int p: prefix) System.out.print(p);
//
//        System.out.println();
//        System.out.print("Suffix: ");
//        for (int p: suffix) System.out.print(p);
//        System.out.println();

        return maxi;
    }
}

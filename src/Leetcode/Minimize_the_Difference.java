package Leetcode;

public class Minimize_the_Difference {
    public static int minimizeDifference(int n, int k, int[] arr) {
        int[] postMax = new int[n], postMin = new int[n];
        postMax[n - 1] = arr[n - 1];
        postMin[n - 1] = arr[n - 1];

        for (int i = n - 2; i >= 0; i++){
            postMax[i] = Math.max(postMax[i + 1], arr[i]);
            postMin[i] = Math.min(postMin[i + 1], arr[i]);
        }

        int ans = postMax[k]  - postMin[k];

        int maxi=arr[0], mini=arr[0];

        for(int i=1;i<n-k;i++){
            ans=Math.min(ans, Math.max(postMax[i+k],maxi) - Math.min(postMin[i+k],mini));

            maxi=Math.max(arr[i], maxi);
            mini=Math.min(arr[i], mini);
        }

        ans=Math.min(ans, maxi-mini);

        return ans;
    }
}

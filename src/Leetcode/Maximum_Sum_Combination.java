package Leetcode;

import java.security.cert.CollectionCertStoreParameters;
import java.util.*;

public class Maximum_Sum_Combination {
    public static void main(String[] args) {
        int N = 2;
        int K = 2;
        int[] A = {3, 2};
        int[] B = {1, 4};
        System.out.println(maxCombinations(N,K,A,B));
    }
    static List<Integer> maxCombinations(int N, int K, int A[], int B[]) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>();
        List<Integer> ans = new ArrayList<>();
        Arrays.sort(A);
        Arrays.sort(B);

        for (int i = N-1; i > N-K-1 ; i--) {
            for (int j = N - 1; j > N-K-1; j--) {
                int sum = A[i]+B[j];
                if (maxHeap.size() < K) maxHeap.add(sum);
                else {
                    if (maxHeap.peek() < sum) {
                        maxHeap.poll();
                        maxHeap.add(sum);
                    } else break;
                }
            }
        }

        while (K != 0) {
            ans.add(maxHeap.poll());
            K--;
        }

        Collections.reverse(ans);
        return ans;
    }
}

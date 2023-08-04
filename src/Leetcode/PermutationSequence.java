package Leetcode;

import java.util.ArrayList;
import java.util.List;

public class PermutationSequence {
    public static void main(String[] args) {
        System.out.println(getPermutation(3,3));
    }
    static String getPermutation(int n, int k) {
        StringBuilder s = new StringBuilder();

//        this minus from 1 because we are taking 0 based indexing.
        k = k -1;
        List<Integer> numbers = new ArrayList<>();

        possiblePerm(n,k,s, numbers);

        return s.toString();
    }

    static void possiblePerm(int n, int k, StringBuilder s, List<Integer> numbers) {
        if (n==0){
            return;
        }

        int fact = factorial(n, numbers);

        int range = fact/n;
        int selectIndex = k / range;

        s.append(numbers.get(selectIndex));
        numbers.remove(selectIndex);

        k = k % range;

        possiblePerm(n - 1, k, s,numbers);
    }

    private static int factorial(int n, List<Integer> numbers) {
        int ans = 1;

        for (int i = 1; i <= n; i++) {
            numbers.add(i);
            ans *= i;
        }
        return ans;
    }
}

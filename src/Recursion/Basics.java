package Recursion;

import java.lang.reflect.Array;
import java.util.*;

public class Basics {
    public static void main(String[] args) {
//        int arr = 123432;
//        String numberStr = String.valueOf(arr);
//
//        boolean ans = isPalindrome(0, numberStr.length() - 1, arr);
//        System.out.println(ans);

        int[] arr = {4,4,4,1,4};
        int n = arr.length;

        Arrays.sort(arr);
        ArrayList<Integer> list = new ArrayList<>();
        List<List<Integer>> parentList = new ArrayList<>();
        ArrayList<Integer> ans = new ArrayList<>();
        subSequencesWithoutDuplicates(arr, list, parentList, 0, n);

        System.out.println(parentList);
    }

    static void name(int i, int n) {
        if (i > n) return;
        System.out.println("Vansh");
        name(i + 1, n);
    }

    static void linearPrint(int i, int n) {
        if (i > n) return;
        System.out.println(i);
        linearPrint(i + 1, n);
    }

    static void reverseLinearPrint(int i, int n) {
        if (i > n) return;
        System.out.println(n - i + 1);
        reverseLinearPrint(i + 1, n);
    }

    static void linearPrintBackTrack(int i, int n) {
        if (i < 1) return;
        reverseLinearPrintBackTrack(i - 1, n);
        System.out.println(i);
    }

    static void reverseLinearPrintBackTrack(int i, int n) {
        if (i < 1) return;
        reverseLinearPrintBackTrack(i - 1, n);
        System.out.println(n - i + 1);
    }

    static int sum = 0;

    static int sumOfFirstXNumsBackTrack(int n) {
        if (n < 1) return 0;
        sumOfFirstXNumsBackTrack(n - 1);
        sum += n;
        return sum;
    }

    static int sumOfFirstXNumsFunctionalWay(int n) {
        if (n < 1) return 0;
        return n + sumOfFirstXNumsFunctionalWay(n - 1);
    }

    static int sumOfFirstXNumsParam(int n, int sum) {
        if (n < 1) return sum;
        return sumOfFirstXNumsParam(n - 1, sum + n);
    }

    static void reverseArrayTwoPointerRecursion(int l, int r, int[] arr) {
        if (l > r) return;

        int temp = arr[l];
        arr[l] = arr[r];
        arr[r] = temp;

        reverseArrayTwoPointerRecursion(l + 1, r - 1, arr);
    }

    static boolean isPalindrome(int l, int r, int arr) {
        if (l == r) return true;

        String numStr = Integer.toString(arr);

        // Create a character array from the string
        char[] charArray = numStr.toCharArray();

        if (charArray[l] != charArray[r]) return false;
        return isPalindrome(l + 1, r - 1, arr);
    }

    static void subSequences(int[] arr, List<Integer> list, int i, int n) {
        if (i == n) {
            System.out.println(list);
            return;
        }

        list.add(arr[i]);
        subSequences(arr, list, i + 1, n);
        list.remove(list.size() - 1);

        // Using recursion here because it will go to its previous node, but as we also need "without taking" wala condition, we again need to call this.
        subSequences(arr, list, i + 1, n);
    }

    static void subSequencesSum(int[] arr, ArrayList<Integer> list, ArrayList<Integer> ans, int i, int n, int sum) {
        if (i == n) {
            ans.add(sum);
            System.out.println(sum);
            return;
        }

        list.add(arr[i]);
        subSequencesSum(arr, list, ans, i + 1, n, sum + arr[i]);
        list.remove(list.size() - 1);

        subSequencesSum(arr, list, ans, i + 1, n, sum);
    }

    static void subSequencesWithoutDuplicates(int[] arr, List<Integer> list, List<List<Integer>> parentList , int i, int n) {
        if (i == n) {
            if (!parentList.contains(list)) {
                parentList.add(new ArrayList<>(list));
            };
            return;
        }

        list.add(arr[i]);
        subSequencesWithoutDuplicates(arr, list, parentList, i + 1, n);
        list.remove(list.size() - 1);

        // Using recursion here because it will go to its previous node, but as we also need "without taking" wala condition, we again need to call this.
        subSequencesWithoutDuplicates(arr, list,  parentList,i + 1, n);
    }
}
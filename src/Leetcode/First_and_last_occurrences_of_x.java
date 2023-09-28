package Leetcode;

import java.util.ArrayList;

public class First_and_last_occurrences_of_x {
    public static void main(String[] args) {
        int[] arr = {5, 7, 7, 7, 8, 8, 8};
        int n = arr.length;

        System.out.println(find(arr, n, 8));
    }
    static ArrayList<Integer> find(int arr[], int n, int x) {
        ArrayList<Integer> ans = new ArrayList<>();
        int s = 0;
        int e = n-1;

        binarySearchForFirst(arr, s, e, x, ans);
        binarySearchForLast(arr, s, e, x, ans);

        return ans;
    }

    static void binarySearchForFirst(int[] arr, int s, int e, int x, ArrayList<Integer> ans) {
        int m = 0;
        int res = -1;

        while (s <= e) {
            m = s + (e-s)/2;
            if (arr[m] < x) s = m + 1;
            else if (arr[m] == x) {
                res = m;
                e = m - 1;
            }
            else e = m - 1;
        }

        ans.add(res);
    }

    static void binarySearchForLast(int[] arr, int s, int e, int x, ArrayList<Integer> ans) {
        int m = 0;
        int res = -1;

        while (s <= e) {
            m = s + (e-s)/2;
            if (arr[m] > x) e = m - 1;
            else if (arr[m] == x) {
                res = m;
                s = m + 1;
            }
            else s = m + 1;
        }

        ans.add(res);
    }
}

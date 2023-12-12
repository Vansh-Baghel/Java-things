package Leetcode;

import java.util.ArrayList;

public class Pythagorean_Triplet {
    public static void main(String[] args) {
        int[] arr = {3,8,5};
        int n = arr.length;
        System.out.println(checkTriplet(arr, n));
    }

    static boolean checkTriplet(int[] arr, int n) {
        // code here
        ArrayList<Integer> sqList = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (!list.contains(arr[i])) {
                sqList.add(arr[i] * arr[i]);
                list.add(arr[i]);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int a1 = list.get(i) * list.get(i);
                int a2 = list.get(j) * list.get(j);

                if (sqList.contains(a1 + a2)) return true;
            }
        }

        return false;
    }
}

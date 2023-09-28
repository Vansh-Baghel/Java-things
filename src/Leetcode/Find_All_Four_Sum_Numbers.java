package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class Find_All_Four_Sum_Numbers {
    public static void main(String[] args) {
        int A[] = {0,0,2,1,1};
        System.out.println(fourSum(A, 3));
    }
    static ArrayList<ArrayList<Integer>> fourSum(int[] arr, int k) {
        Arrays.sort(arr);
        int n = arr.length;
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        HashSet<ArrayList<Integer>> hs = new HashSet<>();

        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 3; j++) {
                int s = j + 1, e = n - 1;
                while (s < e){
                    int sum = arr[i] + arr[j] + arr[s] + arr[e];
                    if (sum == k){
                        ArrayList<Integer> ls = new ArrayList<>(Arrays.asList(arr[i],arr[j],arr[s],arr[e]));
                        if (!hs.contains(ls)){
                            hs.add(ls);
                            res.add(ls);
                            s++;
                            e--;
                        }
                    }
                        else if (sum > k) e--;
                        else s++;
                }
            }
        }

        return res;
    }
}

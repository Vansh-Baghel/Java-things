package Leetcode;
import java.util.*;

public class Find_K_Closest_Elements {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        List<Integer> ans = findClosestElements(arr,4,3);

        System.out.println(ans);
    }

    static List<Integer> findClosestElements(int[] arr, int k, int x) {
//        int s = 0;
//        int e = arr.length - k;
//        List<Integer> ans = new ArrayList<>();
//
//        while (s < e){
//            int m = s + (e-s)/2;
//
//            if (x - arr[m] > arr[m + k]-x){
//                s = m+1;
//            } else{
//                e=m;
//            }
//        }
//
//        // k - 1 because xIndex is in 0 format ie starting from 0.
//            for (int i = 0; i<k;i++){
//                ans.add(arr[s+i]);
//            }
//
//        return ans;

        int s = 0;
        int e = arr.length - 1;
        List<Integer> ans = new ArrayList<>();

        while (e-s >=k){
//            If start ka difference from x is more than that of end, then increase the start.
            if (Math.abs(arr[s]-x) > Math.abs(arr[e]-x)){
                s++;
            } else{
                e--;
            }
        }

            for (int i = s; i<k;i++){
                ans.add(arr[i]);
            }

        return ans;
    }
}

package Leetcode;

import java.util.ArrayList;

public class Find_the_closest_pair_from_two_arrays {
    public static void main(String[] args) {
        int[] a = {1,4,5,7};
        int[] b = {10,20,30,40};
        int n = a.length;
        int m = b.length;
        System.out.println(printClosest(a,b,n,m,32));
    }

    public static ArrayList<Integer> printClosest (int arr[], int brr[], int n, int m, int x) {
        ArrayList<Integer> ans = new ArrayList<>();
        int i = 0, j = m-1, dif=Integer.MAX_VALUE, num1=0,num2=0;

        while (i < n && j >= 0){
            int sum = arr[i] + brr[j];

            int curDif = Math.abs(x-sum);
            if (dif > curDif) {
                dif = curDif;
                num1=arr[i];
                num2=brr[j];
            }

            if(sum < x) i++;
            else j--;

        }
        ans.add(num1);
        ans.add(num2);

        return ans;
    }
}

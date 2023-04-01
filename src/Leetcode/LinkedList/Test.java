package Leetcode.LinkedList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        int[] arr = {3,1,-1,1};
        int f = testCase(arr);
        System.out.println(f);
    }
    public static int[] insertX(int n, int arr[],
                                int x, int pos)
    {
        int i;

        // create a new array of size n+1
        int newarr[] = new int[n + 1];

        // insert the elements from
        // the old array into the new array
        // insert all elements till pos
        // then insert x at pos
        // then insert rest of the elements
        for (i = 0; i < n + 1; i++) {
            if (i < pos - 1)
                newarr[i] = arr[i];
            else if (i == pos - 1)
                newarr[i] = x;
            else
                newarr[i] = arr[i - 1];
        }
        return newarr;
    }

    static int testCase(int[] arr){
        int ans = 0;
        int count = 0;
        int[] newArr = {0};
        for (int i = 0; i < arr.length; i++) {
            ans += arr[i];
            if (ans == 0){
                count++;
                newArr = insertX(arr.length , arr , 100 , arr[i - 1]);
                arr = insertX(arr.length , arr , 100 , arr[i + 1]);
            }
        }
            System.out.println(Arrays.toString(newArr));
        return count;
    }
}

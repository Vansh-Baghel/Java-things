package Leetcode;

import java.util.*;

public class Sort_Alphabetically_the_word {
    public static void main(String[] args) {
        String str = "Lee lives in Zebras Zoo";
        str = str.toLowerCase();
        int[] arr = {4,5,7,2,1,8};
//        PriorityQueue<> minHeap = new PriorityQueue<>();

        int n = str.length();
//        sortNum(arr);

        String[] newStr = str.split(" ");
        Arrays.sort(newStr);
        System.out.println(Arrays.toString(newStr));
    }
}

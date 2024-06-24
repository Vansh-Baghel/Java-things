package Leetcode;

import java.util.Arrays;
import java.util.HashMap;

public class Find_element_occuring_once_when_all_other_are_present_thrice {
    public static void main(String[] args) {
        int[] numbers = {1,1,1,10};

        System.out.println(singleElement2(numbers, numbers.length));
    }
    static int singleElement(int[] arr , int N) {
        // code here
        HashMap<Integer, Integer> hm = new HashMap<>();

        for (int num: arr) hm.put(num, hm.getOrDefault(num, 0) + 1);

        for (var entry: hm.entrySet()){
            int k = entry.getKey();
            int v = entry.getValue();

            if (v == 1) return k;
        }

        return -1;
    }

    static int singleElement2(int[] arr , int N) {
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));

        int s = 0, e = 0;

        while (e < N) {
            while ((e - s + 1) < 3) {
                e++;
                if (e < N && arr[e] != arr[s]) return arr[s];
            }
            s = e + 1;
        }

        return arr[N-1];
    }
}

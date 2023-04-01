package Leetcode;
import java.util.*;

public class Pascals_Triangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> arr = new ArrayList<>();

        for (int i = 0; i < numRows; i++) {
            List<Integer> subArr = new ArrayList<>();
            for (int j = 0; j < i; j++) {
                if (j == 0 || j == i-1) {
                    subArr.add(1);
                }
                else{
                    subArr.add(arr.get(i - 1).get(j - 1) + arr.get(i - 1).get(j));
                }
            }
                arr.add(subArr);
        }
        return arr;
    }
}

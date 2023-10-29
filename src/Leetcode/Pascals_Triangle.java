package Leetcode;
import java.util.*;

public class Pascals_Triangle {
    public static void main(String[] args) {
        System.out.println(generate2(5));
    }
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
    static List<List<Integer>> generate2(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < numRows; i++) {
            List<Integer> list = new ArrayList<>();

            for (int j = 0; j < i + 1; j++) {
                if (j == 0 || j == i){
                    list.add(1);
                } else {
                    list.add(ans.get(i - 1).get(j-1) + ans.get(i-1).get(j));
                }
            }
            ans.add(list);
        }
        return ans;
    }
}

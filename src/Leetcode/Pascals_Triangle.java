package Leetcode;
import java.util.*;

public class Pascals_Triangle {
    public static void main(String[] args) {
        System.out.println(nthRowOfPascalTriangle(5));
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





















    static ArrayList<Long> nthRowOfPascalTriangle(int n) {
        ArrayList<Long> prev = new ArrayList<>();

        for (int r = 0; r < n; r++) {
            ArrayList<Long> cur = new ArrayList<>();
            long mod = 1000000007;

            for (int c = 0; c <= r; c++) {
                if (c == 0 || c == r){
                    cur.add((long)(1));
                } else {
                    long sum = (prev.get(c-1) + prev.get(c)) % mod;
                    cur.add(sum);
                }
            }
            prev = cur;
        }

        return prev;
    }
}

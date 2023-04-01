package Leetcode;
import java.util.*;

public class Pascal_Triangle_II {
    public List<Integer> getRow(int rowIndex) {

        List<Integer> arr = new ArrayList<>();
        arr.add(1);
        for (int i = 1; i <= rowIndex; i++) {
            // We are modifying the value rowIndex - 1 times and baaki we are adding 1 in the last and start.
            // size of arr - 1 will replace the existing value and will add new value based on addition
            for (int j = arr.size() - 1; j > 0; j--) {
                arr.set(j , arr.get(j) + arr.get(j - 1));
            }
            arr.add(1);
        }
        return arr;
    }
}

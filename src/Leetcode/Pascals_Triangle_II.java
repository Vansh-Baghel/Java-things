package Leetcode;

import java.util.*;

public class Pascals_Triangle_II {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> prev = new ArrayList<>();
        if (rowIndex == 0) {
            prev.add(1);
            return prev;
        }
        else if (rowIndex == 1) {
            prev.add(1);
            prev.add(1);
            return prev;
        } else {
            prev.add(1);
            prev.add(1);
        }

        for (int i = 2; i <= rowIndex; i++) {
            List<Integer> cur = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) cur.add(1);
                else {
                    cur.add(prev.get(j - 1) + prev.get(j));
                }
            }
            prev=cur;
        }
        return prev;
    }
}

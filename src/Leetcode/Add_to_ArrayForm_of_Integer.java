//https://leetcode.com/problems/add-to-array-form-of-integer/description/
package Leetcode;
import java.util.*;

public class Add_to_ArrayForm_of_Integer {
    public List<Integer> addToArrayForm(int[] num, int k) {
        int addedNum = 0;
        List<Integer> res = new LinkedList<>();
        for (int i = num.length - 1; i >= 0 ; i--) {
            addedNum = num[i] + k;
            // Added new el in the beginning, here syntax is add (index, el)
            res.add(0 , addedNum % 10);
            // New num would be the addition of both / 10
            k = addedNum / 10;
        }

        while (k > 0) {
            // If the arr length is over before the k is 0, then just split the remaining k.
            res.add(0, k % 10);
            k /= 10;
        }
        return res;
    }
}

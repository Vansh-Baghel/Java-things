package Leetcode;

import java.util.Arrays;
import java.util.Stack;

public class Stock_span_problem {
    public static void main(String[] args) {
        int[] arr = {74, 665, 742, 512, 254, 469, 748, 445, 663, 758, 38, 60, 724, 142, 330, 779, 317, 636, 591, 243, 289, 507, 241, 143, 65, 249, 247, 606, 691, 330, 371, 151, 607, 702, 394, 349, 430, 624, 85, 755, 357, 641, 167, 177, 332, 709, 145, 440, 627, 124, 738, 739, 119, 483, 530, 542, 34, 716, 640, 59, 305, 331, 378, 707, 474, 787, 222, 746, 525, 673, 671, 230, 378, 374, 298, 513, 787, 491, 362, 237, 756, 768, 456, 375, 32, 53, 151, 351, 142, 125, 367, 231, 708, 592, 408, 138, 258, 288, 554, 784, 546, 110, 210, 159, 222, 189, 23, 147, 307, 231, 414, 369, 101, 592, 363, 56, 611, 760, 425, 538, 749, 84, 396, 42, 403, 351, 692, 437, 575, 621, 597, 22, 149, 800};

        int[] ans = calculateSpan(arr, 134);
        System.out.println(Arrays.toString(ans));
    }

    static class Pair {
        int arr_num;
        int span_count;

        public Pair(int arr_num, int span_count) {
            this.arr_num = arr_num;
            this.span_count = span_count;
        }
    }

    static int[] calculateSpan(int price[], int n) {
        int[] ans = new int[n];
        Stack<Pair> st= new Stack<>();

        ans[0] = 1;
        st.push(new Pair(price[0], 1));
        for (int i = 1; i < n; i++) {
                int count = 1;
                while (!st.isEmpty() && st.peek().arr_num <= price[i]) {
                    Pair st_top = st.pop();
                    count += st_top.span_count;
                }
                st.push(new Pair(price[i], count));
                ans[i] = count;
        }
        return ans;
    }
}

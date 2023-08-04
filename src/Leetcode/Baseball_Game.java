package Leetcode;
import java.util.*;

public class Baseball_Game {
    public static void main(String[] args) {
        String[] arr = {"5","2","C","D","+"};
        int ans = calPoints(arr);
        System.out.println(ans);
    }
    static int calPoints(String[] operations) {
        Stack<Integer> st = new Stack<>();
        int t1 = 0;
        int t2 = 0;
        int t3 = 0;

        for(String str: operations){
            if (Objects.equals(str, "+")){
                t1= st.pop();
                t2= st.pop();
                t3= t1+t2;

                st.push(t2);
                st.push(t1);
                st.push(t3);
            } else if (Objects.equals(str, "D")){
                st.push(2 * st.peek());
            } else if (Objects.equals(str, "C")){
                st.pop();
            } else {
                System.out.println(Integer.parseInt(str));
                st.push(Integer.parseInt(str));
            }
        }

        t1 = 0;

        while (!st.isEmpty()) {
            t1 += st.pop();
        }
        return t1;
    }
}

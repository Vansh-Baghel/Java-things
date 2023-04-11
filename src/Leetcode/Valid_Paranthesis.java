package Leetcode;
import java.util.*;

public class Valid_Paranthesis {
        public boolean isValid(String s) {
            Stack<Character> stack = new Stack<Character>();
            for (char c : s.toCharArray()) {
                if (c == '(')
                    stack.push(')');
                else if (c == '{')
                    stack.push('}');
                else if (c == '[')
                    stack.push(']');
                    // Else if condition because any bracket opened must be closed. If not closed, then stack will not be empty.
                else if (stack.isEmpty() || stack.pop() != c)

                    return false;
            }
            return stack.isEmpty();
    }
}

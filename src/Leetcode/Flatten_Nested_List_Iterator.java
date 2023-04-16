package Leetcode;
import java.util.*;

public class Flatten_Nested_List_Iterator  implements Iterator<Integer>{
    public interface NestedInteger {

   // @return true if this NestedInteger holds a single integer, rather than a nested list.
   public boolean isInteger();

   // @return the single integer that this NestedInteger holds, if it holds a single integer
   // Return null if this NestedInteger holds a nested list
   public Integer getInteger();

   // @return the nested list that this NestedInteger holds, if it holds a nested list
   // Return empty list if this NestedInteger holds a single integer
   public List<NestedInteger> getList();
    }

    private Stack<NestedInteger> stack = new Stack<>();

        public Flatten_Nested_List_Iterator(List<NestedInteger> nestedList) {
//            Adding from back to front, so that when we remove, its order must be maintained.
        pushInStack(nestedList);
        }

        private void pushInStack(List<NestedInteger> nestedList) {
            for (int i = nestedList.size() - 1; i >= 0 ; i--) {
                stack.push(nestedList.get(i));
            }
    }

        @Override
        public Integer next() {
//            Taking out topmost NestedInteger, ie , most recent one which was added and as its from back, it will indicate as the next int.
//            getInteger() will return an integer which the nestedInteger holds.
            if (!hasNext()) return null;
            return stack.pop().getInteger();

        }

        @Override
        public boolean hasNext() {
//            Checking if the stack is empty and does the stack contain the integer in the list or not.
            while (!stack.isEmpty() && !stack.peek().isInteger()){
//                getting the list from the stack and pushing into the stack by calling the function which will push all the integers one by one.
                // Also checking if the peek is a list or an integer, this will run only if the peek is list.

                List<NestedInteger> list = stack.pop().getList();
                pushInStack(list);
            }

            return !stack.isEmpty();
        }
}

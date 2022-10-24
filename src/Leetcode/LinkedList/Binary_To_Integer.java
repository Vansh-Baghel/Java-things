//https://leetcode.com/problems/convert-binary-number-in-a-linked-list-to-integer/
package Leetcode.LinkedList;

public class Binary_To_Integer {

      public class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }
    public int getDecimalValue(ListNode head) {
        int length = 0;
        int sum = 0;
        ListNode first = head;

//        length is in 0 convention , ie , if there are 3 elements in list then length is 2 because we want to use length as pow.
        while (first.next != null){
            first = first.next;
            length++;
        }

        first = head;

        while (first != null){
//            If the list contains 0 , then after multiplying we are just adding the old sum value , and if it is 1 , then it will add the old value of sum and also the math pow to it.
            sum += Math.pow(2 , length) * first.val;
            length--;
            first = first.next;
        }
        return sum;
    }
}

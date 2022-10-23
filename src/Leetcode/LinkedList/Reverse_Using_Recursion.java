package Leetcode.LinkedList;

import java.util.List;

public class Reverse_Using_Recursion {

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode reverseList(ListNode head) {
        ListNode headNext = head.next;

        if (head.next == null){
            return head;
        }

//         It will make changes while getting out of the recursive calls.
//         newHead will always be the last element and it will not change . In reverseList(head.next) , the returned value will become head when it goes to public ListNode function call. EG: - reverseList(4) then head = 4 while the recursions are getting out from the stack. In this way , after all recursions are moved out of stack , then our List will be reversed .
        // https://www.youtube.com/watch?v=ugQ2DVJJroc
        ListNode newHead = reverseList(head.next);
        headNext = head.next;
        headNext.next = head;
        head.next = null;
        return newHead;
    }
}

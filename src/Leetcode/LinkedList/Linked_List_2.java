// https://leetcode.com/problems/linked-list-cycle-ii/
package Leetcode.LinkedList;

public class Linked_List_2 {
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

    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        ListNode first = head;
        ListNode second = head;
        int length = 0;

//         After this while loop , will get the length of the cycle.
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast){
                length = lengthOfCycle(slow);
                break;
            }
        }

//         length was initially 0 , so length will change after while loop if (slow == fast) , otherwise slow != fast no cycle is present .
        if (length == 0){
            return null;
        }

//         We will move second length of cycle times ahead.
        while (length > 0){
            second = second.next;
            length--;
        }

//         Place where first and second meets is the place where the cycle starts.
        while (first != second){
            first = first.next;
            second = second.next;
        }
        return second;
    }

    public int lengthOfCycle(ListNode slow){
        ListNode temp = slow;
        int length = 0;

        do {
            length++;
            temp = temp.next;
        }
        while (temp != slow);
        return length;
    }
}
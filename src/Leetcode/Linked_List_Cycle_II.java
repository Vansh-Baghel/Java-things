package Leetcode;

public class Linked_List_Cycle_II {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode detectCycle(ListNode head) {

        ListNode fast = head;
        ListNode slow = head;
        ListNode temp = head;

        if (head == null || head.next == null) return head;

        while (fast != null){
        slow=slow.next;
        fast=fast.next.next;

        if (slow == fast){
            break;
        }
    }
        while (temp!=slow){
            slow = slow.next;
            temp = temp.next;
        }
        return slow;
    }
}

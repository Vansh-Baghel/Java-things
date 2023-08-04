package Leetcode;

public class Linked_List_Cycle {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        if (head == null || head.next == null) return false;

        while (fast != null){
            slow=slow.next;
            fast=fast.next.next;

            if (slow == fast){
                return true;
            }
        }
        return false;
    }
}

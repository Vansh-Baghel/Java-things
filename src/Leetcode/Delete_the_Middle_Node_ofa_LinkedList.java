package Leetcode;

public class Delete_the_Middle_Node_ofa_LinkedList {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode deleteMiddle(ListNode head) {
        // Extra linked list way

//        ListNode slow = head;
//        ListNode fast = head;
//        ListNode prev=new ListNode(0);
//        prev.next = head;
//
//        while (fast != null && fast.next != null){
//            slow=slow.next;
//            fast=fast.next.next;
//            prev=prev.next;
//        }
//        prev.next=slow.next;
//
//        // If the length of ListNode is 1, then return null.
//        return slow != fast ? head : null;

        ListNode slow = head;
        ListNode fast = head;

        while (fast.next.next != null && fast.next.next.next != null){
            slow=slow.next;
            fast=fast.next.next;
        }
            slow.next=slow.next.next;
//
//        // If the length of ListNode is 1, then return null.
        return slow != fast ? head : null;
    }
}

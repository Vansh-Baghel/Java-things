package Leetcode;

public class RemoveDuplicatesfromSortedList {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    public ListNode deleteDuplicates(ListNode head) {
        ListNode temp = head;
        while (temp != null && temp.next != null){
            if (temp.val == temp.next.val){
                temp.next = temp.next.next;
            } else {
                temp = temp.next;
            }
        }
        return head;
    }
}

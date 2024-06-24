package Leetcode;

public class Double_a_Number_Represented_as_a_Linked_List {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode doubleIt(ListNode head) {
        ListNode rev = reverseList(head);
        doubledList(rev);
        return reverseList(rev);
    }

    public void doubledList(ListNode root){
        int carry = 0;
        ListNode lastNode = root;

        while (root != null) {
            int prod = root.val * 2;
            int rem = prod % 10;
            root.val = rem + carry;

            carry = prod / 10;
            if (root.next == null) lastNode = root;
            root = root.next;
        }

        if (carry != 0) lastNode.next = new ListNode(carry);
    }

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode cur = head, prev = null, nxt = head.next;

        while (cur != null) {
            cur.next = prev;
            prev = cur;
            cur = nxt;
            if (nxt != null) nxt = nxt.next;
        }

        return prev;
    }
}

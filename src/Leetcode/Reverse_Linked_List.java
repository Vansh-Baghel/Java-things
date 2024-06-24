package Leetcode;

public class Reverse_Linked_List {
    public class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode prev = null, cur = head, nxt = cur.next;

        while (cur != null){
            cur.next = prev;
            prev= cur;
            cur = nxt;
            if (cur == null) return prev;
            nxt = nxt.next;
        }

        return prev;
    }
}

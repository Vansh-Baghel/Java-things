//https://leetcode.com/problems/remove-nodes-from-linked-list/description/
package Leetcode;

public class RemoveNodes_From_LinkedList {
    public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

    public ListNode reverseList(ListNode head) {
        ListNode prev = null;

        if (head == null || head.next == null) return head;

        ListNode nxt = head.next;

        while (true){
            head.next = prev;
            prev = head;
            head = nxt;
            if (nxt.next != null) nxt = nxt.next;
            else break;
        }
        head.next = prev;
        return head;
    }

    public ListNode removeNodes(ListNode head) {
            head = reverseList(head);
            ListNode temp = head;
            ListNode prev = head;
            head = head.next;

            while (head != null) {
                if (head.val >= prev.val) {
                    prev.next = head;
                    prev = head;
                    head = head.next;
                } else {
                    head = head.next;
                }
            }
                head = reverseList(temp);
                return head;
    }
}

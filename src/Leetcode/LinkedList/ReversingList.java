//https://leetcode.com/problems/reverse-linked-list/
package Leetcode.LinkedList;

public class ReversingList {
     public class ListNode {
 int val;
 ListNode next;
 ListNode() {}
 ListNode(int val) { this.val = val; }
 ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }
    public ListNode reverseList(ListNode head) {

        if (head == null){
            return head;
        }

        ListNode present = head;
        ListNode previous = null;
        ListNode future = present.next;

        while (present != null){
            present.next = previous;
            previous = present;
            present = future;
//             Moving future ahead while checking.
            if (future != null){
                future = future.next;
            }
        }
//         Because in the end the present will be null, so the tail will be the previous.
        return previous;
    }
}

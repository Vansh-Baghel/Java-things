//https://leetcode.com/problems/middle-of-the-linked-list/
package Leetcode.LinkedList;

public class Middle_Of_LinkedList {
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

    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        do {
            slow = slow.next;
            fast = fast.next.next;
        }while(fast != null && fast.next != null);

        return slow;


////         This works!! The previous solution is the solution of the video and easier too.
//        ListNode temp = head;
//        int length = 0;
//
//        if (head.next == null){
//            return head;
//        }
//
//        while (temp != null){
//            length++;
//            temp = temp.next;
//        }
//
////        Converting to 0 convention.
//        length = length - 1;
//
//        int mid = (length % 2 == 0) ? length / 2 : (length / 2) + 1;
//
//        while (mid > 0){
//            head = head.next;
//            mid--;
//        }
//
//        return head;
    }
}

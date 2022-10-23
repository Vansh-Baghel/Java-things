//https://leetcode.com/problems/linked-list-cycle/
package Leetcode.LinkedList;

public class List_Cycle {

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

    static boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

//         If the ListNode wasn't a cycle, then fast will reach the null value . We have to consider fast.next otherwise the inner values of fast.next will give null which will throw an error.
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;

            if (fast == slow){
                return true;
            }
        }
        return false;
    }
}

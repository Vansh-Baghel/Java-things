//https://leetcode.com/problems/remove-nth-node-from-end-of-list/
package Leetcode.LinkedList;

public class Remove_NthNode_From_End_of_List {
  public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
    public ListNode removeNthFromEnd(ListNode head, int n) {

//      Creating new Node and assigning all values as it in the beginning.
        ListNode start = new ListNode();
        ListNode fast = start;
        ListNode slow = start;
        start.next = head;

//        Taking fast pointer ahead by n times as we want to remove nth node from behind so when it reaches nth from front then will start to move slow pointer. Slow pointer will reach one node behind the node which is to be removed.
//        How? lenght - k = left over nodes . This left over nodes will stop exactly one node behind of k.
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }

        // If fast pointer is already at the end . For [1] , it will return null and not 1 which was the problem without this condition.
        if(fast.next == null) {
            return head.next;
        }

        while (fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }
//        here we are skipping the next node as that is the one which we dont want in our list.
        slow.next = slow.next.next;

        return head;
    }
}

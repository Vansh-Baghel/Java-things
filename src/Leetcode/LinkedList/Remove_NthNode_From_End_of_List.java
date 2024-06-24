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











    public ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode dummy = new ListNode();
        ListNode slow = dummy;
        ListNode fast = dummy;
        dummy.next = head;

        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }

        if (fast.next == null) return head.next;

        while (fast.next != null){
            slow = slow.next;
            fast = fast.next;
        }

        // slow.next != fast because for conditions like {1,2}, n = 1, it won't work
        slow.next = slow.next.next;

        return head;
    }

    public ListNode removeNthFromEnd3(ListNode head, int n) {
        int size = 0;
        ListNode temp = head;
        ListNode traverse = head;

        while (temp != null){
            size++;
            temp = temp.next;
        }

        int k = size - n + 1;

        if (n == size){
            head = head.next;
        } else {
            if (size == 1) return null;
            for (int i = 1; i < size - n; i++) {
                traverse = traverse.next;
            }

            traverse.next = traverse.next.next;
        }

        return head;
    }
}

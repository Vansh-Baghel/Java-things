//https://leetcode.com/problems/reverse-nodes-in-k-group/
package Leetcode.LinkedList;

public class Reverse_Nodes_kGroup {
  public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

//  https://www.youtube.com/watch?v=Of0HPkk3JgI&t=1053s
    public ListNode reverseKGroup(ListNode head, int k) {
        if (k <= 1 || head == null) return head;

//        pre is new node.
        ListNode dummy = new ListNode(0);
//        dummy is storing the very first pre. Then will return its next value to get the first value of the list.
        dummy.next = head;
        ListNode pre = dummy;
        ListNode nex = dummy;
        ListNode cur = dummy;
        int count = 0;

        while (cur.next != null){
            cur = cur.next;
            count++;
        }

        while (count >= k){
//        cur must be pre ka next and pre ka next will be at the first element of next range . So cur will always be the first element of loops .
            cur = pre.next;
//            nex will be modified in the for loop.
            nex = cur.next;

            for (int i = 1; i < k; i++) {
                cur.next = nex.next;
                nex.next = pre.next;
                pre.next = nex;
                nex = cur.next;
            }
//            Keeping cur at 1 in 3,2,1,4,5,6 after rotation and not changing it . We are resetting pre ka value as we need it only in loop.
            pre = cur;
            count -= k;
        }
        return dummy.next;
    }
}

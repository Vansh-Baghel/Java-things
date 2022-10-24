//https://leetcode.com/problems/swap-nodes-in-pairs/
package Leetcode.LinkedList;

public class Swap_Nodes {
  public class ListNode {
      int val;
      ListNode next;
     ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode nex = dummy;
        ListNode cur = dummy;
        int count = 0;

        while (cur.next != null){
            cur = cur.next;
            count++;
        }

        while (count >= 2){
//        cur must be pre ka next and pre ka next will be at the first element of next range . So cur will always be the first element of loops .
            cur = pre.next;
//            nex will be modified in the for loop.
            nex = cur.next;

            cur.next = nex.next;
            nex.next = cur;
            pre.next = nex;
            nex = cur.next;
//            Keeping cur at 1 in 3,2,1,4,5,6 after rotation and not changing it . We are resetting pre ka value as we need it only in loop.
            pre = cur;
            count -= 2;
        }
        return dummy.next;
    }
}

//https://leetcode.com/problems/rotate-list/
package Leetcode.LinkedList;

public class Rotate_List{
  public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

    public ListNode rotateRight(ListNode head, int k) {
        if (k <= 0 || head == null || head.next == null){
            return head;
        }

//        length = 1 because it will not check for the last element as we are giving the condition as last.next.
        int length = 1;
        ListNode last = head;
//        length will keep increasing and last will reach the last of the list.
        while (last.next != null){
            last = last.next;
            length++;
        }

//        We want this only that the last element connects to first element.
        last.next = head;

//        If k is smaller than length , then it will just return k.
        int rotations = k % length;
//        skip will say that how many elements ahead we must move.
        int skip = length - rotations;
        ListNode newLast = head;

//        This will take us one element behind the element which will become new head after rotating.
        for (int i = 0; i < skip - 1 ; i++) {
            newLast = newLast.next;
        }

//        As mentioned , so its next element will be the new head.
        head = newLast.next;
//      it will be the end of the list.
        newLast.next = null;
        return head;
    }
}

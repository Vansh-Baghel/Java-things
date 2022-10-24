//https://leetcode.com/problems/delete-node-in-a-linked-list/
package Leetcode.LinkedList;

public class DeleteNode_LinkedList {

  public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
    public void deleteNode(ListNode node) {
//         We are changing the value itself , and assigning the value of its next element.
        node.val = node.next.val;
//         Here we are pointing to the next k next element because the next element ka value is in the node which we want to change.
        node.next = node.next.next;
    }
}

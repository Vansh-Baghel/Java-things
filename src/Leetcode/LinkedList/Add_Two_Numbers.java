//https://leetcode.com/problems/add-two-numbers/submissions/
package Leetcode.LinkedList;

import Leetcode_Manual_Input.LinkedList;

public class Add_Two_Numbers {
  static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

    static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
      ListNode prev = new ListNode(0);
      ListNode head = prev;
      int carry = 0;

//      if carry is 1 and if l1 and l2 are null , then we have to add an extra element to the list therefore we will accept any carry which comes.
      while (l1 != null || l2 != null || carry != 0){
//          cur and prev are 2 new Nodes.
          ListNode cur = new ListNode(0);
//          if l1 or l2 are null then keep it 0 while adding so that ans will be of other list.
          int sum = ((l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + carry);
//          Only when sum is 10 , it will store 0 in it .
          cur.val = sum % 10;
//          It will give 1 when the sum is 10 , otherwise carry will be 0. In next iteration the carry will be added with the Lists.
          carry = sum / 10;
//          We are joining the next of prev as cur so that new elements keeps on adding everytime.
          prev.next = cur;
//          We have to update prev so that its next points to new List otherwise it will keep changing itself on the same place.
          prev = cur;

//          We have to update the lists after adding.
          l1 = ((l1 == null) ? l1 : l1.next);
          l2 = ((l2 == null) ? l2 : l2.next);
      }
//      head was pointing to the new ListNode of 0 and from its next our List starts.
      return head.next;
    }


















        public static ListNode arrayToList(int[] arr) {
            if (arr == null || arr.length == 0) {
                return null;
            }

            ListNode head = new ListNode(arr[0]);
            ListNode current = head;

            for (int i = 1; i < arr.length; i++) {
                current.next = new ListNode(arr[i]);
                current = current.next;
            }

            return head;
        }

        public static void printList(ListNode head) {
            ListNode current = head;
            while (current != null) {
                System.out.print(current.val + " ");
                current = current.next;
            }
            System.out.println();
        }

        public static void main(String[] args) {
            int[] arr = {9,9,9,9,9,9,9};
            int[] arr1 = {9,9,9,9};
            ListNode head1 = arrayToList(arr);
            ListNode head2 = arrayToList(arr1);
//            printList(head);
            ListNode ans = addTwoNumbers2(head1, head2);
            printList(ans);
        }

    static ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        ListNode temp = new ListNode(0);
        ListNode head = temp;
        int carry = 0;

        while (l1!=null || l2 != null || carry != 0){
            int sum = 0;
            if (l1!=null && l2 != null) {
                sum = l1.val + l2.val + carry;
                l1=l1.next;
                l2=l2.next;
            }
            else if (l1 != null) {
                sum = l1.val + carry;
                l1=l1.next;
            }
            else if (l2 != null) {
                sum = l2.val + carry;
                l2=l2.next;
            } else sum = carry;
            carry = sum / 10;
            temp.next = new ListNode(sum % 10);
            temp = temp.next;
        }

        return head.next;
    }
}

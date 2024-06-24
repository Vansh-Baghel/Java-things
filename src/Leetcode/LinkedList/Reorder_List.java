package Leetcode.LinkedList;

public class Reorder_List {
    public static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
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
        int[] arr = {1, 2, 3, 3, 2, 1};
        ListNode head = arrayToList(arr);
        reorderList(head);
        printList(head);
    }

    public static ListNode middleElement(ListNode head){
            ListNode slow = head;
            ListNode fast = head;

            while (fast != null && fast.next != null){
                slow = slow.next;
                fast = fast.next.next;
            }
            return slow;
      }

    public static ListNode reverseList(ListNode head){
        ListNode previous = null;
        ListNode present = head;
        ListNode presentNext = present.next;

        while (present != null){
            present.next = previous;
            previous = present;
            present = presentNext;

            if (presentNext != null){
                presentNext = presentNext.next;
            }
        }
        return previous;
    }


    public static void reorderList(ListNode head) {
        ListNode mid = middleElement(head);
        ListNode reversedList = reverseList(mid);
        ListNode headSecond = reversedList;

        while (head != null && headSecond != null){
            ListNode temp = head.next;
            head.next = headSecond;
            head = temp;

            temp = headSecond.next;
            headSecond.next = head;
            headSecond = temp;
        }

        if (head != null){
            head.next = null;
        }
    }
}

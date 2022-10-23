package Leetcode.LinkedList;

public class Reorder_List {
    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

      public ListNode middleElement(ListNode head){
            ListNode slow = head;
            ListNode fast = head;

            while (fast != null && fast.next != null){
                slow = slow.next;
                fast = fast.next.next;
            }
            return slow;
      }

        public ListNode reverseList(ListNode head){
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


            public void reorderList(ListNode head) {
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

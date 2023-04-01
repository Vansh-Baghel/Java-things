package Leetcode;

public class Insertion_Sort_List {

    public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
        public ListNode insertionSortList(ListNode head) {
            ListNode dummy = new ListNode(-1);
            ListNode cur = head;

            while (cur != null) {
                ListNode temp = cur.next;
                ListNode prev = dummy;
                ListNode nxt = dummy.next;

                while (nxt != null) {
//                    If nxt ka value is greater than cur means we can attach the cur to the next assuming a sorted list.
                    if (nxt.val > cur.val)
                        break;
//                    Else just iterate the prev and nxt.
                    prev = nxt;
                    nxt = nxt.next;
                }
//                Attaching cur to nxt, nxt ka prev to cur because it would be smaller than cur, and shifting the cur to temp where cur.next is stored.
                cur.next = nxt;
                prev.next = cur;
                cur = temp;
            }

            return dummy.next;
        }
}

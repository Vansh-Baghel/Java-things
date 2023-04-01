package Leetcode;

public class Remove_Duplicates_from_SortedList {
    public class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }

    public ListNode deleteDuplicates(ListNode head) {
        ListNode temp = head;
        ListNode nxt = head.next;

        while (nxt != null){
            if (nxt == temp){
                temp.next = nxt.next;
                nxt = nxt.next;
            }
            else {
                temp=temp.next;
                nxt= nxt.next;
            }
        }
        return head;
    }
}

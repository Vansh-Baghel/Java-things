package Leetcode;

public class Remove_Duplicates_from_SortedList_2 {
    public class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode nxt = head.next;

        if (head.val == nxt.val){
            // Checking if both are equal multiple times, then just update the nxt variable and return as new head once its finished.
            while (nxt != null && nxt.val == head.val) nxt = nxt.next;
            return deleteDuplicates(nxt);
        }else{
            // Otherwise if its not equal then we would need to add it in the list.
            head.next = deleteDuplicates(nxt);
        }
        return head;

    }
}


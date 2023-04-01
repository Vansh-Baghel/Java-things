package Leetcode;
import java.util.*;

public class Remove_LinkedList_Elements {
    public class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode();
        dummy.next = head;

        ListNode cur = head;
        ListNode prev = dummy;

        if (head == null) return null;

        while (cur != null){
            if (cur.val == val){
                prev.next = cur.next;
            }
            else {
                prev = cur;
            };
            cur = cur.next;
        }
        return dummy.next;
    }
    }


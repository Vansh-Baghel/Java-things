package Leetcode;
import java.util.*;

public class Reverse_Linked_List_II {
    static class ListNode {
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
        int[] arr = {1,2,3,4,5};
        ListNode head = arrayToList(arr);
        ListNode ans = reverseBetween(head, 1, 4);
        printList(ans);
    }

    static ListNode reverseRange(ListNode cur, int length) {
        if (length == 0) return cur;

        ListNode prev=null,nxt=cur.next, start = cur;
        while (length--!=0){
            cur.next=prev;
            prev=cur;
            cur=nxt;
            nxt=nxt.next;
        }

        start.next = nxt;
        cur.next=prev;
        return cur;
    }

    static ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == 1){
            return head = reverseRange(head, right-left);
        }

        ListNode temp = head;
        for (int i = 0; i < left-2; i++) {
            temp=temp.next;
        }
        temp.next = reverseRange(temp.next, right-left);
        return head;
    }
}

package Leetcode;

public class Palindrome_LL {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }


    static ListNode createLinkedList(int[] array) {
        if (array == null || array.length == 0) {
            return null;
        }

        ListNode head = new ListNode(array[0]);
        ListNode current = head;

        for (int i = 1; i < array.length; i++) {
            current.next = new ListNode(array[i]);
            current = current.next;
        }

        return head;
    }


    static void display(ListNode head) {
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2};
        ListNode head = createLinkedList(arr);
        boolean ans = isPalindrome(head);
        System.out.println(ans);
    }


    static boolean isPalindrome(ListNode head) {

        if (head == null) return true;
        ListNode prev= null, curr = head, nxt = head.next, slow = head, fast= head;

        while (fast!=null && fast.next != null) {
            slow=slow.next;
            fast=fast.next.next;
        }

        ListNode mid = slow;

        while (true){
            slow.next = prev;
            prev = slow;
            slow = nxt;
            if (nxt == null) break;
            nxt = nxt.next;
        }

        while (head != mid && prev != mid){
            if (head.val != prev.val) return false;
            head=head.next;
            prev=prev.next;
        }
        return true;
    }
}

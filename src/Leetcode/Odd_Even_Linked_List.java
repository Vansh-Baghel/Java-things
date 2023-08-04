package Leetcode;

public class Odd_Even_Linked_List {
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
        ListNode temp = head;

        while (temp != null) {
            System.out.println(temp.val);
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};
        ListNode head = createLinkedList(arr);
        ListNode ans = oddEvenList(head);
        display(ans);
    }

    static ListNode oddEvenList(ListNode head) {
        ListNode odd = head;
        ListNode even = head.next;
        ListNode to= odd;
        ListNode te= even;

        if (head.next == null || head.next.next == null) return head;

        while (te != null && te.next != null){
            to.next = te.next;
            to=to.next;
            te.next=to.next;
            te=te.next;
        }

        to.next = even;
        return odd;
    }
}


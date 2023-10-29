package Leetcode;

import Leetcode_Manual_Input.LinkedList;

public class Reverse_a_linked_list {
    static class Node {
        int val;
        Node next;
        Node(int val) {
            this.val = val;
        }
    }

    public static Node arrayToList(int[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }

        Node head = new Node(arr[0]);
        Node current = head;

        for (int i = 1; i < arr.length; i++) {
            current.next = new Node(arr[i]);
            current = current.next;
        }

        return head;
    }

    public static void printList(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6};
        Node head = arrayToList(arr);
        Node rev = reverseList(head);
        printList(rev);
    }

    static Node reverseList(Node head) {
        if (head == null || head.next == null) return head;

        Node cur = head, prev=null,nxt=head.next;

        while (cur != null){
            cur.next = prev;
            prev=cur;
            cur=nxt;
            if (nxt != null) nxt=nxt.next;
        }

        return prev;
    }
}

package Leetcode;

import Leetcode_Manual_Input.LinkedList;

public class Decimal_Equivalent_of_Binary_Linked_List {
    static class Node {
        int data;
        Node next;
        Node(int d)  { data = d;  next = null; }
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
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 0};
        Node head = arrayToList(arr);
        System.out.println(DecimalValue(head));
    }

    static long DecimalValue(Node head) {
        StringBuilder num = new StringBuilder();

        // Convert the linked list to a string
        while (head != null) {
            num.append(head.data);
            head = head.next;
        }

        int res = 0, pv = 1;

        // Traverse the string in reverse, multiplying each bit by increasing powers of 2
        for (int i = num.length() - 1; i >= 0; i--) {
            res += pv * (num.charAt(i) - '0');
            pv = (pv * 2) % 1000000007; // Update power of 2 modulo 10^9+7
            res %= 1000000007; // Update result modulo 10^9+7
        }

        return res;
    }
}

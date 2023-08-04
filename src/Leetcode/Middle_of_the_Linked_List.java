package Leetcode;

import Leetcode.LinkedList.Practice;

import java.util.List;

public class Middle_of_the_Linked_List {
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
        int[] arr = {1,2,3,4,5,6};
        ListNode head = createLinkedList(arr);
        ListNode ans = middleNode(head);
        display(ans);
    }

    static ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null){
            slow=slow.next;
            fast=fast.next.next;
        }

        return slow;
    }
}

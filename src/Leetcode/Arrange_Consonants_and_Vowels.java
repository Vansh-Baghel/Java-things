package Leetcode;

import Leetcode_Manual_Input.LinkedList;

public class Arrange_Consonants_and_Vowels {
    static class Node {
        char data;
        Node next;

        public Node(char data){
            this.data = data;
            next = null;
        }
    }

    public static Node arrayToList(char[] arr) {
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
        char[] arr = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i'};

        Node head = arrayToList(arr);
        printList(arrangeCV(head));
    }

    public static Node arrangeCV(Node head){
        //write code here and return the head of changed linked list
        Node head2 = null, vowels = null, dummy = new Node('0'), newHead = null;
        dummy.next = head;

        while (dummy != null && dummy.next != null){
            if (isVowel(dummy.next.data)) {
                while (dummy.next != null && isVowel(dummy.next.data)) {
                    if (vowels == null) {
                        vowels = dummy.next;
                        newHead = vowels;
                    }
                    else {
                        vowels.next=dummy.next;
                        vowels=vowels.next;
                    }

                    if (dummy.next.next == null) {
                        break;
                    }

                    dummy=dummy.next;
                }

                dummy.next=vowels.next;
            }

            if (head2 == null) head2 = dummy.next;

            dummy=dummy.next;
        }

        vowels.next = head2;

        return newHead;
    }

    public static boolean isVowel(char ch){
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }
}

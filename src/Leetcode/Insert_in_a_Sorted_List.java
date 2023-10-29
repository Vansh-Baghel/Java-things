package Leetcode;

import Leetcode_Manual_Input.LinkedList;

public class Insert_in_a_Sorted_List {
    static class Node {
        int data;
        Node next;

        Node(int x) {
            data = x;
            next = null;
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
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {1, 10, 21, 32, 38};
        Node head = arrayToList(arr);
        Node head1 = sortedInsert2(head, 1);
        printList(head1);
    }

    // TLE
    static Node sortedInsert(Node head1, int key) {
        Node temp = head1, newNode = new Node(key), prev=null;
        while (temp != null){
            if (temp.data > newNode.data){
                if (prev == null) {
                    newNode.next = temp;
                    return newNode;
                } else {
                    // Attaching the newNode and then attaching that newnNode with further Nodes.
                    prev.next=newNode;
                    prev=prev.next;
                    prev.next=temp;
                    return head1;
                }
            }

            if (temp.next == null) {
                temp.next=newNode;
                return head1;
            }
            prev=temp;
            temp=temp.next;
        }
        return head1;
    }

    static Node sortedInsert2(Node head1, int key) {
        // Add your code here.
        Node temp = head1, newNode = new Node(key);

        if(temp != null && temp.data >= newNode.data){
            newNode.next=head1;
            head1=newNode;
        }
        else{
            while (temp != null && temp.next!=null && temp.next.data <= newNode.data){
                temp=temp.next;
            }
            newNode.next=temp.next;
            temp.next=newNode;
        }

        return head1;
    }
}

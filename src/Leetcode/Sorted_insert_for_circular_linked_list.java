package Leetcode;

import Leetcode_Manual_Input.LinkedList;

public class Sorted_insert_for_circular_linked_list {
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
        int[] arr = {1,2,4};
        Node head = arrayToList(arr);
        printList(sortedInsert(head, 2));
    }

    static Node sortedInsert(Node head, int data) {
        // code here
        Node newNode = new Node(data);
        Node prev=null;
        Node tmp = head;

        // One hee node hoga in this condition
        if (head == null) {
            newNode.next = newNode;
            return newNode;
        }

        // First node hee badha hua toh last node ko join krna hoga newNode se
        if (head.data >= data){
            newNode.next = head;

            while (tmp.next!=head){
                tmp=tmp.next;
            }

            tmp.next=newNode;

            return newNode;
        } else{
            while (tmp.next!=head && tmp.next.data<data) {
                tmp = tmp.next;
            }
            newNode.next=tmp.next;
            tmp.next=newNode;
            return head;
        }
    }
}

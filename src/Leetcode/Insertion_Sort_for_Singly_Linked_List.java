package Leetcode;

public class Insertion_Sort_for_Singly_Linked_List {
    static class Node {
        int data;
        Node next;
        Node(int d) {data = d; next = null; }
    }

    static Node arrayToList(int[] arr) {
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
        int[] arr = {30,23,28,30};
        Node head = arrayToList(arr);
        printList(insertionSort2(head));
    }

    // O(N^3)
    public static Node insertionSort(Node head_ref){
        if (head_ref == null || head_ref.next == null) return head_ref;
        Node cur = head_ref.next;

        while (cur != null){
            Node temp = head_ref, prev = null;

            while (temp.next != cur){
                temp = temp.next;
            }

            prev = temp;

            if (prev.data > cur.data){
                swap(prev, cur);
                if (head_ref.next != cur) cur = prev;
            } else cur=cur.next;
        }

        return head_ref;
    }

    static void swap(Node prev, Node cur){
        int temp = prev.data;
        prev.data = cur.data;
        cur.data = temp;
    }


    static Node insertionSort2(Node head){
        if (head == null || head.next == null) return head;
        Node tail = head, cur = head.next, nxt = cur.next;
        tail.next = null;

        while (cur != null){
            nxt = cur.next;

            if (cur.data >= tail.data){
                cur.next = tail;
                tail = cur;
            } else {
                Node temp = tail;

                while (temp.next != null && temp.next.data > cur.data){
                    temp = temp.next;
                }

                cur.next = temp.next;
                temp.next = cur;
            }

            cur = nxt;
            if (nxt != null) nxt = nxt.next;
        }

        return reverse(tail);
    }

    private static Node reverse(Node tail) {
        Node cur = tail, nxt = tail.next, prev = null;

        while (cur!= null){
            cur.next = prev;
            prev=cur;
            cur = nxt;
            if (nxt != null) nxt = nxt.next;
        }

        return prev;
    }
}

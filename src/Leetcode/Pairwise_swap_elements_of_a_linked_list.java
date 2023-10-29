package Leetcode;

public class Pairwise_swap_elements_of_a_linked_list {
    static class Node
    {
        int data;
        Node next;
        Node(int key)
        {
            data = key;
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
        int[] arr = {1, 2, 3, 4, 5, 6};
        Node head = arrayToList(arr);
        Node rev=pairwiseSwap(head);
        printList(rev);
    }

    static Node pairwiseSwap(Node head) {
        if (head == null || head.next == null) return head;

        Node cur = head, nxt=head.next,nxtNext = nxt.next, prev=new Node(-1), dummy=prev;

        while (nxt != null){
            nxt.next = cur;
            prev.next=nxt;
            prev=cur;
            cur=nxtNext;
            if (cur == null) break;
            nxt=cur.next;
            if (nxt != null) nxtNext = nxt.next;
        }

        prev.next= cur;

        return dummy.next;
    }
}

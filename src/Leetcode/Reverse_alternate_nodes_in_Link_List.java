package Leetcode;

public class Reverse_alternate_nodes_in_Link_List {
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
        int[] arr = {10, 4, 9, 1, 3, 5, 9, 4};
        Node head = arrayToList(arr);
        rearrange(head);
        printList(head);
    }

    static void rearrange(Node odd) {
        // add your code here
        if (odd == null || odd.next == null || odd.next.next==null) return;

        Node cur = odd, prev = null, nxt=cur.next, nxtNext = nxt.next;

        while (nxt != null){
            if (nxtNext != null) cur.next = nxtNext;
            nxt.next=prev;
            prev=nxt;
            if (nxtNext == null) break;
            cur=nxtNext;
            nxt=nxtNext.next;
            if (nxt != null) nxtNext=nxt.next;
        }

        cur.next=prev;
    }

    static void rearrange2(Node odd) {
        // add your code here
        if (odd == null || odd.next == null) return;

        Node cur = odd, prev = null, nxt=cur.next, dummyH = new Node(-1), dummyIt = dummyH;

        // dividing the nodes into 2. Then attaching one with another after reversing the another one.
        while (nxt != null) {
            cur.next=nxt.next;
            dummyIt.next=nxt;
            dummyIt=nxt;
            dummyIt.next=null;
            if (cur.next == null) break;
            cur=cur.next;
            nxt=cur.next;
        }

        cur.next=reverseList(dummyH.next);
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

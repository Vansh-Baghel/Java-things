package Leetcode;

public class Merge_2_sorted_linked_list_in_reverse_order {
    class Node
    {
        int data;
        Node next;

        Node(int d)
        {
            data = d;
            next = null;
        }
    }

    Node mergeResult(Node node1, Node node2) {
        Node temp = new Node(-1), res = temp, t1 = node1, t2 = node2;

        while (t1 != null && t2 != null) {
            if (t1.data < t2.data){
                temp.next = new Node(t1.data);
                temp = temp.next;
                t1 = t1.next;
            } else {
                temp.next = new Node(t2.data);
                temp = temp.next;
                t2 = t2.next;
            }
        }

        while (t1 != null){
            temp.next = new Node(t1.data);
            temp = temp.next;
            t1 = t1.next;
        }

        while (t2 != null){
            temp.next = new Node(t2.data);
            temp = temp.next;
            t2 = t2.next;
        }

        return reverse(res.next);
    }

    static Node reverse(Node head){
        if (head == null) return null;

        Node prev = null, cur = head, nxt = head.next;

        while (true){
            cur.next = prev;
            prev = cur;
            cur = nxt;
            if (nxt == null) break;
            nxt = nxt.next;
        }

        return prev;
    }

    Node mergeResult2(Node node1, Node node2) {
        Node nxt = null, cur = null, t1 = node1, t2 = node2;

        while (t1 != null && t2 != null) {
            if (t1.data < t2.data){
                cur = new Node(t1.data);
                cur.next = nxt;
                nxt = cur;
                t1 = t1.next;
            } else {
                cur = new Node(t2.data);
                cur.next = nxt;
                nxt = cur;
                t2 = t2.next;
            }
        }

        while (t1 != null){
            cur = new Node(t1.data);
            cur.next = nxt;
            nxt = cur;
            t1 = t1.next;
        }

        while (t2 != null){
            cur = new Node(t2.data);
            cur.next = nxt;
            nxt = cur;
            t2 = t2.next;
        }

        return nxt;
    }
}

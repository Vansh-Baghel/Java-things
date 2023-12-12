package Leetcode;

import java.util.*;

public class Intersection_of_two_sorted_Linked_lists {
    public static class Node {
        int data;
        Node next;
        Node(int d)  { data = d;  next = null; }
    }

    static Node findIntersection(Node head1, Node head2) {
        Node ans = new Node(0);
        Node temp = ans;

        while (head1 != null && head2 != null){
            if(head1.data == head2.data) {
                ans.next = new Node(head1.data);
                ans = ans.next;
                head1 = head1.next;
                head2 = head2.next;
            }
            else if(head1.data < head2.data) {
                head1 = head1.next;
            } else {
                head2 = head2.next;
            }
        }

        return temp.next;
    }
}

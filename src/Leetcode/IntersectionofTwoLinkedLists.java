package Leetcode;
import java.util.*;

public class IntersectionofTwoLinkedLists {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode getIntersectionNode(ListNode head1, ListNode head2) {
        ListNode tempA = head1;
        ListNode tempB = head2;
        int countA = 0;
        int countB = 0;
        while (tempA != null) {
            tempA = tempA.next;
            countA++;
        }
        while (tempB != null) {
            tempB = tempB.next;
            countB++;
        }
        tempA = head1;
        tempB = head2;

        if (countB > countA) {
            for (int i = 0; i < countB - countA; i++) {
                tempB = tempB.next;
            }
        } else {
            for (int i = 0; i < countA - countB; i++) {
                tempA = tempA.next;
            }
        }

        while (tempB != tempA) {
            tempB = tempB.next;
            tempA = tempA.next;
        }

        return tempB;
    }

    public ListNode getIntersectionNode2(ListNode head1, ListNode head2) {
        ListNode tempA = head1;
        ListNode tempB = head2;

        while (tempA != tempB){
            tempA = tempA != null ? tempA.next : head2;
            tempB = tempB != null ? tempB.next : head1;
        }

        return tempB;
    }
}
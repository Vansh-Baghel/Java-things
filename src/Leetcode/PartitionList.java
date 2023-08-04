package Leetcode;

public class PartitionList {
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
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }

    public static void main(String[] args) {
        int[] arr = {1,1};
        ListNode head = createLinkedList(arr);
        ListNode ans = partition(head, 0);
        display(ans);
    }

    static ListNode partition(ListNode head, int x) {
        if (head == null) return null;

        ListNode head2 = null,head1 = null, t1 = new ListNode(0), t2 = new ListNode(0), it = head;

        while (it != null) {
            if (it.val < x) {
                if (t1.next != null) {
                    t1.next = it;
                } else{
                    head1= it;
                }
                t1 = it;
            } else {
                if (t2.next != null) {
                    t2.next = it;
                } else {
                    head2 = it;
                }
                t2 = it;
            }
            it = it.next;
        }
        t1.next = head2;
        t2.next = null;

        return head1 == null ? head2 : head1;
    }

//    Lesser if-else, clean code
    static ListNode partition2(ListNode head, int x) {
        if (head == null || head.next == null) return head;

        ListNode headG = new ListNode(0), headS = new ListNode(0), s = headS, g = headG, curr = head;

        while (curr!= null){
            if (curr.val < x){
                s.next = curr;
                s = s.next;
            } else {
                g.next = curr;
                g = g.next;
            }
            curr = curr.next;
        }
        s.next = headG.next;
        g.next = null;
        return headS.next;
    }
}

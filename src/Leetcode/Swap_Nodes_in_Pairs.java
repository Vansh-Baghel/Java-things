package Leetcode;

public class Swap_Nodes_in_Pairs {
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
        int[] arr = {1,2,3,4,5,6};
        ListNode head = createLinkedList(arr);
        ListNode ans = swapPairs(head);
        display(ans);
    }

    static ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode curr = head, prev = new ListNode(0), nxt = curr.next, nxtNext = nxt.next, dummy = new ListNode(0);
        dummy.next = head.next;
        prev.next = curr;

        while (curr != null && nxt != null){
            nxt.next=curr;
            curr.next=nxtNext;
            prev.next=nxt;
            prev = curr;

            curr=nxtNext;
            if (curr != null) {
                nxt=curr.next;
                if (nxt != null) {
                    nxtNext=nxt.next;
                }
            }
        }
        return dummy.next;
    }
}

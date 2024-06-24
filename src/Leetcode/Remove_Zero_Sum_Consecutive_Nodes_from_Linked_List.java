package Leetcode;

import java.util.HashMap;

public class Remove_Zero_Sum_Consecutive_Nodes_from_Linked_List {
    public static class ListNode {
        int val;

        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static ListNode arrayToList(int[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }

        ListNode head = new ListNode(arr[0]);
        ListNode current = head;

        for (int i = 1; i < arr.length; i++) {
            current.next = new ListNode(arr[i]);
            current = current.next;
        }

        return head;
    }

    public static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {3,-3};
        ListNode head = arrayToList(arr);
        printList(removeZeroSumSublists(head));
    }

    public static ListNode removeZeroSumSublists(ListNode head) {
        HashMap<Integer, ListNode> hm = new HashMap<>();
        int sum = 0;
        ListNode dummy = new ListNode(0), temp = head;
        dummy.next=head;
        hm.put(0, dummy);

        while (head!=null){
            sum+=head.val;
            if (hm.containsKey(sum)) {
                // Previous ka next will point to current ka next.
                ListNode leftmostToRemove = hm.get(sum);
                ListNode it = leftmostToRemove.next;
                int tempSum = sum;

                while (it!=head) {
                    tempSum+=it.val;
                    if (it!=head) hm.remove(tempSum);
                    it=it.next;
                }

                leftmostToRemove.next = it.next;
            } else hm.put(sum, head);

            head=head.next;
        }

        return dummy.next;
    }
}

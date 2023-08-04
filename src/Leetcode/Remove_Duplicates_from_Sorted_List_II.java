package Leetcode;

public class Remove_Duplicates_from_Sorted_List_II {
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
        int[] arr = {1, 1, 2, 2, 3, 4, 4, 5};
        ListNode head = createLinkedList(arr);
        ListNode ans = deleteDuplicates(head);
        display(ans);
    }

    static ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode prev = null;
        ListNode current = head;

        while (current != null) {
            boolean isDuplicate = false;
            while (current.next != null && current.val == current.next.val) {
                current = current.next;
                isDuplicate = true;
            }
            if (isDuplicate) {
                if (prev == null) {
                    head = current.next;
                } else {
                    prev.next = current.next;
                }
            } else {
                prev = current;
            }
            current = current.next;
        }
        return head;
    }
}

package Leetcode;

import java.util.List;

public class Merge_Two_Sorted_Lists {
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
        ListNode temp = head;

        while (temp != null) {
            System.out.println(temp.val);
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        int[] arr1 = {1,2,4};
        int[] arr2 = {1,3,4};
        ListNode head1 = createLinkedList(arr1);
        ListNode head2 = createLinkedList(arr2);

        ListNode ans = mergeTwoLists(head1, head2);
        display(ans);
    }

    static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode ans = new ListNode(0);
        ListNode temp = ans;

        while (list1 != null && list2 != null){
            if(list1.val > list2.val){
                ans.next = list2;
                ans = ans.next;
                list2=list2.next;
            } else {
                ans.next = list1;
                ans = ans.next;
                list1=list1.next;
            }
        }
        while (list1 != null){
            ans.next = list1;
            ans = ans.next;
            list1=list1.next;
        }
        while (list2 != null){
            ans.next = list2;
            ans = ans.next;
            list2=list2.next;
        }
        return temp.next;
    }
}

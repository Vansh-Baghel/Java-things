package Leetcode;

    public class Merge_In_Between_Linked_Lists {
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

    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        int idx = 0;
        ListNode res = new ListNode(0);
        ListNode temp = list1, prev = null;

        while (temp != null && idx != a){
            idx++;
            prev=temp;
            temp=temp.next;
        }

        res.next = list1;
        res = res.next;

        prev.next = list2;

        // Find tail of list2.
        while (list2.next != null){
            list2=list2.next;
        }

        // Find b from list1.
        while (temp != null && b!=idx){
            idx++;
            temp=temp.next;
        }

        // temp.next because bth index bhi remove krna hai
        list2.next = temp.next;

        return res;
    }

    public ListNode mergeInBetween2(ListNode list1, int a, int b, ListNode list2) {
        int idx = 0;
        ListNode left = null, right = list1;

        for (int i = 0; i <= b; i++){
            if (i == a - 1) {
                left = right;
            }
            right=right.next;
        }

        left.next=list2;

        // Iterating through list2
        while (left.next != null) left=left.next;

        left.next = right;

        return list1;
    }
}

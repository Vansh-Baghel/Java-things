package Leetcode.LinkedList;

import java.util.List;

public class Merge_Sort {
    public class ListNode {
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

    public ListNode Merge_SortList(ListNode head) {
            if (head == null || head.next == null){
                return head;
            }

            ListNode mid = getMid(head);
            ListNode left = Merge_SortList(head);
            ListNode right = Merge_SortList(mid);

            return mergeTwoLists(left , right);
        }

//  This gives us two ListNodes . One from head to mid and second from mid to end.
    ListNode getMid(ListNode head) {
//        midPrev is set to null.
        ListNode midPrev = null;
        while (head != null && head.next != null) {
//            First condition will be true and rest will be false and once while loop ends , will get the middle element.
            midPrev = (midPrev == null) ? head : midPrev.next;
            head = head.next.next;
        }
//        Here we are setting mid as midPrev + 1 (midPrev is the original mid) so that we can set the mid (midPrev) ka next as null .
//        EG: - 1,2,3,4,5 here midPrev = 3 , mid = 4 , and we are setting midPrev.next as null so 2 nodes will be 1,2,3,null and 4,5.
        ListNode mid = midPrev.next;
        midPrev.next = null;
        return mid;
    }

        public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

//         This temp is made to not touch the head variable so that we can return the elements from the start.
            ListNode temp = new ListNode();
//         This head will return all the elements from the head.
            ListNode head = temp;

            while (list1 != null && list2 != null) {
                if (list1.val < list2.val) {
                    temp.next = list1;
                    list1 = list1.next;
                    temp = temp.next;
                } else {
                    temp.next = list2;
                    list2 = list2.next;
                    temp = temp.next;
                }
            }
            while (list1 != null) {
                temp.next = list1;
                list1 = list1.next;
                temp = temp.next;
            }
            while (list2 != null) {
                temp.next = list2;
                list2 = list2.next;
                temp = temp.next;
            }

//         head is the very first element which will be 0 therefore we are returning head.next.
            return head.next;
        }
}


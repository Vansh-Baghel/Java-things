//https://leetcode.com/problems/merge-two-sorted-lists/
package Leetcode;

public class Merge_Two_SortedLists {
    public class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode temp = new ListNode();
        ListNode head = temp;

        while (list1 != null && list2 != null){
            if (list1.val > list2.val){
                temp.next = list2;
                list2 = list2.next;
                temp = temp.next;
            }
            else{
                temp.next = list1;
                list1 = list1.next;
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
        return head.next;
    }
    }

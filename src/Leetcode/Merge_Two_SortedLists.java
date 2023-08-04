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

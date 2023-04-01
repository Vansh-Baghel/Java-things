//https://leetcode.com/problems/partition-list/
package Leetcode;

public class Partition_List {
    public class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }

    public ListNode partition(ListNode head, int x) {

        ListNode list1 = new ListNode(0);
        ListNode list2 = new ListNode(0);

        ListNode list1Start = list1;
        ListNode list2Start = list2;

        while (head != null){
            if (head.val < x){
                list1.next = head;
                list1 = list1.next;
            }
            else{
                list2.next = head;
                list2 = list2.next;
            }
            head = head.next;
        }
        list1.next = list2Start.next;
        list2.next = null;
        return list1Start.next;
    }
}

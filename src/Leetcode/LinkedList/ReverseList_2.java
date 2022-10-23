//https://leetcode.com/problems/reverse-linked-list-ii/
package Leetcode.LinkedList;

public class ReverseList_2 {
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

    public ListNode reverseBetween(ListNode head, int left, int right) {
//        Two pointers from the beginning of List.
        ListNode present = head;
        ListNode previous = null;

//        Means no part must be reversed.
        if (left == right){
            return head;
        }

//        This will take us to the part which we want to reverse , if left is 2 means the reverse thing must be started from 2nd index. Therefore take present and previous to that part and as we need the element behind the left to join in the end , we will assign first with the previous element.
        for (int i = 0; present != null && i < left - 1; i++) {
            previous = present;
            present = present.next;
        }

//        newEnd will be the first element when reverse is done . So we will connect its first to the first element of the list.
        ListNode newEnd = present;
        ListNode first = previous;
        ListNode presentNext = present.next;

//      This loop will return the reversed part and present will be one element ahead of given right and previous will be at right . Note:- We have reversed the arrows and not the value yet. EG: - After the for loop , it will be something like 1 -> 4 <- 3 <- 2 -> 5 This is done , We have to do this 1 -> 2 -> 3 -> 4 -> 5 . 4 will be newEnd and 1 will be first in 1 -> 4 <- 3 <- 2 -> 5 .
        for (int i = 0; present != null && i < right - left + 1; i++) {
            present.next = previous;
            previous = present;
            present = presentNext;

//            Since we dont want first element to point to null in the end , we will provide this condition.
            if (presentNext != null){
                presentNext = presentNext.next;
            }
        }
//        newEnd.next must be the present ie 4 ka next must be 5 . present will become right + 1 ie 5 . Therefore they must join to reverse the list.
        newEnd.next = present;
//        If there exist no element in the beginning , then just make the previous element (here it will be at right index , ie , 2 , as head. Otherwise if first exist , then its next must be previous. This will join the list completely.
        if (first != null){
            first.next = previous;
        }
        else{
            head = previous;
        }
        return head;
    }
}

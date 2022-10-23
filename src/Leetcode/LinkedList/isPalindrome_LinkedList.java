//https://leetcode.com/problems/palindrome-linked-list/
package Leetcode.LinkedList;

public class isPalindrome_LinkedList {
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

    public ListNode middleList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

        private ListNode reverseList(ListNode head) {
            if (head == null){
                return head;
            }

            ListNode present = head;
            ListNode previous = null;
            ListNode future = present.next;

            while (present != null){
                present.next = previous;
                previous = present;
                present = future;
//             Moving future ahead while checking.
                if (future != null){
                    future = future.next;
                }
            }
//         Because in the end the present will be null, so the tail will be the previous.
            return previous;
        }


        public boolean isPalindrome(ListNode head) {
//        Will return the mid of the list.
            ListNode mid = middleList(head);
//            Will reverse the list from the mid, ie , the second half.
            ListNode secondHead = reverseList(mid);
//            reverseFirst will be the secondHead ka first element.
            ListNode reverseFirst = secondHead;

//            break loop if any of the one list reaches null.
            while (head != null && secondHead != null) {
//                if any val doesn't matches in both the lists , then just break.
                if (head.val != secondHead.val) {
                    break;
                }
                head = head.next;
                secondHead = secondHead.next;
            }
//            Re-reversing from the part where we reversed the list.
            reverseList(reverseFirst);

//          If the lists are palindrome then any of the one heads will be null . Therefore this will give us true or false.
            if (head == null || secondHead == null){
                return true;
            }
            return false;
        }
}
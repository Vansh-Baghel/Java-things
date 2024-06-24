//https://leetcode.com/problems/palindrome-linked-list/
package Leetcode.LinkedList;

public class isPalindrome_LinkedList {
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
        int[] arr = {1, 2, 3, 3, 2, 1};
        ListNode head = arrayToList(arr);
        System.out.println(isPalindrome(head));
    }

    public static ListNode middleList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

        private static ListNode reverseList(ListNode head) {
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


        public static boolean isPalindrome(ListNode head) {
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



    public static boolean isPalindrome2(ListNode head) {
        StringBuilder str1 = new StringBuilder(), str2 = new StringBuilder();

        ListNode prev = reverse(head, str1);

        while (prev!=null){
            str2.append(prev.val);
            prev=prev.next;
        }

        return str1.toString().equals(str2.toString());
    }

    public static ListNode reverse(ListNode cur, StringBuilder str){
        if (cur == null) return cur;

        ListNode prev = null, nxt = cur.next;

        while (cur!=null){
            cur.next = prev;
            str.append(cur.val);
            prev = cur;
            cur = nxt;
            if (nxt != null) nxt = nxt.next;
        }

        return prev;
    }
}
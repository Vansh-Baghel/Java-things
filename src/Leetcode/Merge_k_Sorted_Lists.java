package Leetcode;

import java.util.List;

public class Merge_k_Sorted_Lists {
    public static ListNode createListOfLists(int[][] arrays) {
        if (arrays == null || arrays.length == 0) {
            return null;
        }

        ListNode outerHead = new ListNode(0);
        ListNode outerCurr = outerHead;

        for (int[] innerArray : arrays) {
            if (innerArray == null || innerArray.length == 0) {
                continue;
            }

            ListNode innerHead = new ListNode(0);
            ListNode innerCurr = innerHead;

            for (int value : innerArray) {
                innerCurr.next = new ListNode(value);
                innerCurr = innerCurr.next;
            }

            outerCurr.next = new ListNode(innerHead.next.val);
            outerCurr = outerCurr.next;
        }

        return outerHead.next;
    }

    // Helper method to print the list of lists
    public static void printListOfLists(ListNode list) {
        ListNode currentOuter = list.next;
        while (currentOuter != null) {
            ListNode currentInner = currentOuter.next;
            while (currentInner != null) {
                System.out.print(currentInner.val + " ");
                currentInner = currentInner.next;
            }
            System.out.println();
            currentOuter = currentOuter.next;
        }
    }

    public static void main(String[] args) {
        int[][] arrays = {{1, 2, 3}, {4, 5}, {6, 7, 8, 9}};
        ListNode listOfLists = createListOfLists(arrays);
        printListOfLists(listOfLists);
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

        static ListNode mergeKLists(ListNode[] lists) {

            ListNode mergedOne = null;
            for (int i = 0; i < lists.length; i++) {
                if (i == 0) {
                    mergedOne = mergeTwoLists(lists[i], lists[i + 1]);
                    i++;
                } else{
                    mergedOne = mergeTwoLists(mergedOne, lists[i]);
                }
            }
            return mergedOne;
        }

        static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
            ListNode ans = new ListNode(0);
            ListNode temp = ans;

            while (list1 != null && list2 != null) {
                if (list1.val > list2.val) {
                    ans.next = list2;
                    ans = ans.next;
                    list2 = list2.next;
                } else {
                    ans.next = list1;
                    ans = ans.next;
                    list1 = list1.next;
                }
            }
            while (list1 != null) {
                ans.next = list1;
                ans = ans.next;
                list1 = list1.next;
            }
            while (list2 != null) {
                ans.next = list2;
                ans = ans.next;
                list2 = list2.next;
            }
            return temp.next;
        }
    }

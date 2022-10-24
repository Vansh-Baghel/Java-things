//https://leetcode.com/problems/intersection-of-two-linked-lists/
package Leetcode.LinkedList;

public class Intersection_Of_Two_LinkedList {
  public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
  }

        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
//          int countA = 0;
//          int countB = 0;
//          int skip = 0;
//          ListNode tempA = headA;
//          ListNode tempB = headB;
//
////          first we counted the length of both heads.
//          while (tempA != null){
//              tempA = tempA.next;
//              countA++;
//          }
//            while (tempB != null){
//                tempB = tempB.next;
//                countB++;
//            }
//
////          Then we subtracted the bigger length from the smaller one and shifted the larger length utne times ahead.
//            if (countA > countB){
//                skip = countA - countB;
//                for (int i = 0; headA != null && i < skip; i++) {
//                    headA = headA.next;
//                }
//            }
//            else if (countA < countB){
//                skip = countB - countA;
//                for (int i = 0; headB != null && i < skip; i++) {
//                    headB = headB.next;
//                }
//            }
//
//            while (headA != null && headB != null){
////                if both the memory spot is same , then just return it.
//                if (headA == headB){
//                    return headA;
//                }
////                else keep iterating.
//                headA = headA.next;
//                headB = headB.next;
//            }
////            if none of them is true , then return null.
//            return null;

//            More efficient
            if (headA == null || headB == null) return headA;

            ListNode a = headA;
                ListNode b = headB;

                while (a != b){
    //                If none of them intersect then a will point at headB ie the first element of headB and when b become null , then it will point of first element of headA . This will make loops start from the same point means if there is difference in size then it will be no more problem and they will meet if any intersection exists.
    //              In the end if no node intersect then both will eventually intersect at null , which will be returned.
                    a = a == null ? headB : a.next;
                    b = b == null ? headA : b.next;
                }
                return a;
            }
}

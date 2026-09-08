/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) return null;
         ListNode a = headA;
         ListNode b = headB;
         while(a != null && b != null){
            a = a.next;
            b = b.next;
         }
         int ExtraLenA = 0;
         while(a != null){
          ExtraLenA++;
          a = a.next;
         }
         int ExtraLenB = 0;
         while(b != null){
          ExtraLenB++;
          b = b.next;
         }
         while(ExtraLenA --> 0){
            headA = headA.next;
         }
         while(ExtraLenB --> 0){
            headB = headB.next;
         }
        while(headA != null && headB != null){
            if(headA == headB){
                return headA;
            } else{
                headA = headA.next;
                headB = headB.next;
            }
        }
        return null;
    }
}
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mid(ListNode head){
        ListNode fast = head;
        ListNode slow = head;
        while(fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
    public ListNode reverse(ListNode head){
       ListNode prev = null;
       ListNode curr = head;
       while(curr != null){
        ListNode next = curr.next;
        curr.next = prev;
        prev = curr;
        curr = next;
       }
       return prev;
    }
    public void reorderList(ListNode head) {
        if(head == null || head.next == null) return ;
        ListNode middle = mid(head);
        ListNode list2 = middle.next;
        middle.next = null;
        ListNode temp = head;
        ListNode head2 = reverse(list2);
        ListNode temp1 = head;
        ListNode temp2 = head2;
        while(temp2 != null){
            ListNode next1 = temp1.next;
            ListNode next2 = temp2.next;
            temp1.next = temp2;
            temp2.next = next1;
            temp1 = next1;
            temp2 = next2;
        }
    }
}
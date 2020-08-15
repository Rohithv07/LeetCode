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
        if (headA == null || headB == null)
            return null;
        ListNode headAPointer = headA;
        ListNode headBPointer = headB;
        
        while(headAPointer != headBPointer){
            if (headAPointer == null)
                headAPointer = headB;
            else
                headAPointer = headAPointer.next;
            if (headBPointer == null)
                headBPointer= headA;
            else
                headBPointer = headBPointer.next;
        }
        return headAPointer;
    }
}


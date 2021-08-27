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
    public ListNode swapNodes(ListNode head, int k) {
        int index = 0;
        ListNode dummyPointer = head;
        ListNode pointerFromStart = head;
        ListNode pointerFromLast = head;
        while (index < k - 1) {
            dummyPointer = dummyPointer.next;
            index += 1;
        }
        // this dummyPointer will be the required kth node from first
        pointerFromStart = dummyPointer;
        dummyPointer = dummyPointer.next;
        
        // now to find the kth pointer from end, we just move dummypointer until it reaches null, simultaneously we move the
        // pointerFromLast
        
        while (dummyPointer != null) {
            pointerFromLast = pointerFromLast.next;
            dummyPointer = dummyPointer.next;
        }
        // swap
        int temp = pointerFromLast.val;
        pointerFromLast.val = pointerFromStart.val;
        pointerFromStart.val = temp;
        return head;
    }
}

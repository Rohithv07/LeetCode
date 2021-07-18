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
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null)
            return null;
        ListNode current = head;
        for (int i=0; i<k; i++) {
            if (current == null)
                return head;
            current = current.next;
        }
        current = head;
        ListNode previous = null;
        for (int i=0; i<k; i++) {
            ListNode nextNode = current.next;
            current.next = previous;
            previous = current;
            current = nextNode;
        }
        head.next = reverseKGroup(current, k);
        return previous;
    }
    
    public ListNode reverse(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode current = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return head;
    }
    
    // these reverse functions are written just as a practice and these function are not used
    public ListNode reverse2(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode current = head;
        ListNode previous = null;
        while (current != null) {
            ListNode nextNode = current.next;
            current.next = previous;
            previous = current;
            current = nextNode;
        }
        return previous;
    }
}
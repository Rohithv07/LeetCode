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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null)
            return null;
        ListNode resultNode = new ListNode(0);
        resultNode.next = head;
        ListNode fast = resultNode;
        ListNode slow = resultNode;
        // move fast pointer n places forward
        while (n-- > 0) {
            fast = fast.next;
        }
        // now move the fast pointer and slow pointer until fast reaches end and slow will be the node whos next is the one to be skipped
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return resultNode.next;
    }
}

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
    public ListNode mergeNodes(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode result = new ListNode(0);
        ListNode current = result;
        int sum = 0;
        ListNode running = head.next;
        while (running != null) {
            int value = running.val;
            if (value != 0) {
                sum += value;
            }
            else {
                current.next = new ListNode(sum);
                current = current.next;
                sum = 0;
            }
            running = running.next;
        }
        return result.next;
    }
}
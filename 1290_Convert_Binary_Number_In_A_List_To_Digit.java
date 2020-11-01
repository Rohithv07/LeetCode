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
    public int getDecimalValue(ListNode head) {
        // here find the length of the list and satrt taking the power from length - 1
        int length = 0;
        ListNode current = head;
        while (current != null) {
            length ++;
            current = current.next;
        }
        int startingPower = length - 1;
        int respectiveDigit = 0;
        while (head != null) {
            int currentValue = head.val;
            respectiveDigit += ((int)Math.pow(2, startingPower--) * currentValue);
            head = head.next;
        }
        return respectiveDigit;
    }
}
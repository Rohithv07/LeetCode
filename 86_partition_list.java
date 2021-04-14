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
    public ListNode partition(ListNode head, int x) {
        if (head == null)
            return head;
        ListNode current = head;
        ListNode lessThanX = new ListNode(0);
        ListNode tempLessThanX = lessThanX;
        ListNode greaterThanOrEqualToX = new ListNode(0);
        ListNode tempGreaterThanOrEqualToX = greaterThanOrEqualToX;
        while (current != null) {
            if (current.val < x) {
                tempLessThanX.next = new ListNode(current.val);
                tempLessThanX = tempLessThanX.next;
            }
            else {
                tempGreaterThanOrEqualToX.next = new ListNode(current.val);
                tempGreaterThanOrEqualToX = tempGreaterThanOrEqualToX.next;
            }
            current = current.next;
        }
        tempLessThanX.next = greaterThanOrEqualToX.next;
        return lessThanX.next;
    }
}

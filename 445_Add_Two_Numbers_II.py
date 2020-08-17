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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode reversedL1 = reverse(l1);
        ListNode reversedL2 = reverse(l2);
        ListNode head = new ListNode(0);
        ListNode current = head;
        int carry = 0;
        while (reversedL1 != null || reversedL2 != null){
            int a = (reversedL1 != null) ? reversedL1.val : 0;
            int b = (reversedL2 != null) ? reversedL2.val: 0;
            int sum = a + b + carry;
            carry = sum / 10;
            int lastDigit = sum % 10;
            current.next = new ListNode(lastDigit);
            if (reversedL1 != null)
                reversedL1 = reversedL1.next;
            if (reversedL2 != null)
                reversedL2 = reversedL2.next;
            current = current.next;
        }
        if (carry > 0){
            current.next = new ListNode(carry);
            current = current.next;
        }
        ListNode finalResult = reverse(head.next);
        return finalResult;
    }
    public ListNode reverse(ListNode node){
        if (node == null || node.next == null)
            return node;
        ListNode current = node;
        ListNode previous = null;
        while(current != null){
            ListNode currentNext = current.next;
            current.next = previous;
            previous = current;
            current = currentNext;
        }
        return previous;
    }
}

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
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        // find the middle
        ListNode slow = head;
        ListNode fast = head;
        ListNode breakPoint = null;
        while (fast != null && fast.next != null) {
            breakPoint = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        breakPoint.next = null;
        ListNode left = sortList(head);
        ListNode right = sortList(slow);
        // merge left and right to correct posiition
       // ListNode finalResult = mergeRecursive(left, right);
        ListNode finalResult = mergeIterative(left, right);
        return finalResult;
    }
    
    private ListNode mergeIterative(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }
        ListNode result = new ListNode(0);
        ListNode current = result;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                current.next = l1;
                l1 = l1.next;
            }
            else if (l2.val < l1.val) {
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
            if (l1 == null) {
                current.next = l2;
            }
            else {
                current.next = l1;
            }
        }
        return result.next;
    }
    
    private ListNode mergeRecursive(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode result = null;
        if (l1.val <= l2.val) {
            result = l1;
            result.next = mergeRecursive(l1.next, l2);
        }
        else {
            result = l2;
            result.next = mergeRecursive(l1, l2.next);
        }
        return result;
    }
}



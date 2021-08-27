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
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null)
            return null;
        ListNode current = head;
        ListNode previous = null;
        while(m > 1){
            previous = current;
            current = current.next;
            m --;
            n --;
        }
        ListNode connection = previous;
        ListNode tail = current;
        while(n > 0){
            ListNode currentNext = current.next;
            current.next = previous;
            previous = current;
            current = currentNext;
            n --;
        }
        if (connection != null)
            connection.next = previous;
        else
            head = previous;
        tail.next = current;
        return head;
    }
}

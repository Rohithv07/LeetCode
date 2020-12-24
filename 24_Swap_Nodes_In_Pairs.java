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
    public ListNode swapPairs(ListNode head) {
        if (head == null)
            return null;
        ListNode tempNode = new ListNode(0);
        // let the next of tempNode be head
        tempNode.next = head;
        // let currentNode points to temp, ie typically nothing
        ListNode currentNode = tempNode;
        // check the next or next.next is not null of current
        while (currentNode.next != null && currentNode.next.next != null) {
            ListNode first = currentNode.next;
            ListNode second = currentNode.next.next;
            // now do the swapping, make the next of first as next of second
            first.next = second.next;
            // now the pointing changes. Now the head, or the first element changes
            // also the adjacent element also changes
            currentNode.next = second;
            currentNode.next.next = first;
            currentNode = currentNode.next.next;
        }
        return tempNode.next;
    }
}


/*
|<--|--->   |
1 - 2 - 3 - 4
    |
(1, 2) - (3, 4)
    |
(2, 1) - (4, 3)
    
first.next = second.next
current.next = second
current.next.next = first
current = current.next.next
*/

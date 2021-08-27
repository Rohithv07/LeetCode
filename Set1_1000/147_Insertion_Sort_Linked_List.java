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
    // we create an null valued node first
    ListNode sorted = null;
    public ListNode insertionSortList(ListNode head) {
        if (head == null)
            return null;
        // store the head to another pointer
        ListNode current = head;
        // traverse
        while (current != null) {
            // store the next node
            ListNode nextNode = current.next;
            // helper function helps in sortibng
            sortList(current);
            current = nextNode;
        }
        head = sorted;
        return head;
    }
    public void sortList(ListNode node) {
        // the base conditon if the sorted is null or the value in sorted > that in current node
        if (sorted == null || sorted.val >= node.val) {
            node.next = sorted;
            sorted = node;
        } 
        else {
            // have a temp node for traversing
            ListNode temp = sorted;
            while (temp.next != null && temp.next.val < node.val)
                temp = temp.next;
            // now we got the position required position
            node.next = temp.next;
            temp.next = node;
        }
    }
} 
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
    public ListNode swapNodes(ListNode head, int k) {
        int index = 0;
        ListNode dummyPointer = head;
        ListNode pointerFromStart = head;
        ListNode pointerFromLast = head;
        while (index < k - 1) {
            dummyPointer = dummyPointer.next;
            index += 1;
        }
        // this dummyPointer will be the required kth node from first
        pointerFromStart = dummyPointer;
        dummyPointer = dummyPointer.next;
        
        // now to find the kth pointer from end, we just move dummypointer until it reaches null, simultaneously we move the
        // pointerFromLast
        
        while (dummyPointer != null) {
            pointerFromLast = pointerFromLast.next;
            dummyPointer = dummyPointer.next;
        }
        // swap
        int temp = pointerFromLast.val;
        pointerFromLast.val = pointerFromStart.val;
        pointerFromStart.val = temp;
        return head;
    }
}

// without changing the node value rather changing the node pointer

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
    public ListNode swapNodes(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        int length = findLength(head);
        if (k > length) {
            return head;
        }
        ListNode previousFront = null;
        ListNode front = head;
        ListNode previousBack = null;
        ListNode back = head;
        for (int i = 1; i < k; i++) {
            previousFront = front;
            front = front.next;
        }
        for (int i = 1; i < length - k + 1; i++) {
            previousBack = back;
            back = back.next;
        }
        if (previousBack != null) {
            previousBack.next = front;
        }
        if (previousFront != null) {
            previousFront.next = back;
        }
        ListNode temp = front.next;
        front.next = back.next;
        back.next = temp;
        if (k == 1) {
            head = back;
        }
        if (k == length) {
            head = front;
        }
        return head;
    }
    
    private int findLength(ListNode node) {
        if (node == null) {
            return 0;
        }
        if (node.next == null) {
            return 1;
        }
        int length = 0;
        while (node != null) {
            node = node.next;
            length++;
        }
        return length;
    }
}
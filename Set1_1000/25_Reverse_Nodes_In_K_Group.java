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
// https://youtu.be/Of0HPkk3JgI
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = dummy;
        ListNode pre = dummy;
        ListNode nex = dummy;
        int count = 0;
        while (cur.next != null) {
            count++;
            cur = cur.next;
        }
        while (count >= k) {
            cur = pre.next;
            nex = cur.next;
            for (int i=1; i<k; i++) {
                cur.next = nex.next;
                nex.next = pre.next;
                pre.next = nex;
                nex = cur.next;
            }
            pre = cur;
            count -= k;
        }
        return dummy.next;
    }
}










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
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null)
            return null;
        ListNode current = head;
        for (int i=0; i<k; i++) {
            if (current == null)
                return head;
            current = current.next;
        }
        current = head;
        ListNode previous = null;
        for (int i=0; i<k; i++) {
            ListNode nextNode = current.next;
            current.next = previous;
            previous = current;
            current = nextNode;
        }
        head.next = reverseKGroup(current, k);
        return previous;
    }
    
    public ListNode reverse(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode current = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return head;
    }
    
    // these reverse functions are written just as a practice and these function are not used
    public ListNode reverse2(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode current = head;
        ListNode previous = null;
        while (current != null) {
            ListNode nextNode = current.next;
            current.next = previous;
            previous = current;
            current = nextNode;
        }
        return previous;
    }
}




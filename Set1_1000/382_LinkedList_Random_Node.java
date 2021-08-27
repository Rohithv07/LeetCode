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
    
    /** @param head The linked list's head.
        Note that the head is guaranteed to be not null, so it contains at least one node. */
    private ListNode head;
    public Solution(ListNode head) {
        this.head = head;
    }
    
    /** Returns a random node's value. */
    public int getRandom() {
        int scope = 1;
        int chosen = 0;
        ListNode current = this.head;
        while (current != null) {
            if (Math.random() < 1.0 / scope) 
                chosen = current.val;
            scope += 1;
            current = current.next;
        }
        return chosen;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */

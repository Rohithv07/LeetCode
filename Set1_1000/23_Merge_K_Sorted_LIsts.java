// minHeap

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
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (ListNode head : lists) {
            while (head != null) {
                minHeap.add(head.val);
                head = head.next;
            }
        }
        ListNode result = new ListNode(0);
        ListNode current = result;
        while (!minHeap.isEmpty()) {
            current.next = new ListNode(minHeap.remove());
            current = current.next;
        }
        return result.next;
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
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        return partition(lists, 0, lists.length - 1);
    }
    
    public ListNode partition(ListNode [] lists, int start, int end) {
        if (start > end) {
            return null;
        }
        if (start == end) {
            return lists[start];
        }
        int middle = start + (end - start) / 2;
        ListNode part1 = partition(lists, start, middle);
        ListNode part2 = partition(lists, middle + 1, end);
        return merge(part1, part2);
    }
    
    public ListNode merge(ListNode part1, ListNode part2) {
        if (part1 == null) {
            return part2;
        }
        if (part2 == null) {
            return part1;
        }
        if (part1.val < part2.val) {
            part1.next = merge(part1.next, part2);
            return part1;
        }
        part2.next = merge(part1, part2.next);
        return part2;
    }
}
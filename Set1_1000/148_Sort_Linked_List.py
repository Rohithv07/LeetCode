# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def sortList(self, head: ListNode) -> ListNode:
        if head is None or head.next is None:
            return head
        middle = self.findMiddle(head)
        nextToMiddle = middle.next
        middle.next = None
        
        left = self.sortList(head)
        right = self.sortList(nextToMiddle)
        sortedList = self.finalMergeSort(left, right)
        return sortedList

    def findMiddle(self, node):
            if node is None or node.next is None:
                return node
            slow = node
            fast = node
            while (fast.next != None and fast.next.next != None):
                slow = slow.next
                fast = fast.next.next
            return slow
        
    def finalMergeSort(self, a, b):
        result = None
        if a == None:
            return b
        if b == None:
            return a
        if a.val <= b.val:
            result = a
            result.next = self.finalMergeSort(a.next, b)
        else:
            result = b
            result.next = self.finalMergeSort(a, b.next)
            
        return result


# adding java code here : 

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
        #// 1. find the middle
        #// 2. split the list to left and right wrt to head and the middle
        #// 3. merge this splitted list
        #// 4. return the final merged list
        
        ListNode slow = head;
        ListNode fast = head;
        ListNode previous = null;
        while (fast != null && fast.next != null) {
            previous = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        previous.next = null;
        #// ListNode middle = findMiddle(head);
        #// ListNode nextOfMiddle = middle.next;
        #// middle.next = null;
        
        ListNode left = sortList(head);
        ListNode right = sortList(slow);
        
        ListNode finalMergedList = merge(left, right);
        return finalMergedList;
    }
    
    """
    private ListNode findMiddle(ListNode node) {
        if (node == null || node.next == null) {
            return node;
        }
        ListNode slow = node;
        ListNode fast = node;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    } 
    """
    
    private ListNode merge(ListNode node1, ListNode node2) {
        if (node1 == null && node2 == null) {
            return null;
        }
        if (node1 == null) {
            return node2;
        }
        if (node2 == null) {
            return node1;
        }
        ListNode result = null;
        if (node1.val <= node2.val) {
            result = node1;
            result.next = merge(node1.next, node2);
        }
        else {
            result = node2;
            result.next = merge(node1, node2.next);
        }
        return result;
    }
}
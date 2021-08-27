# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def hasCycle(self, head: ListNode) -> bool:
        """
        O(n) time O(1) space
        slow = head
        fast = head
        while(fast != None and fast.next != None):
            slow = slow.next
            fast = fast.next.next
            
            if slow == fast:
                return True
            
        return False
        """
        
        # O(n) time and O(n) space
        dictionary = collections.defaultdict(ListNode)
        while(head):
            if head in dictionary:
                return True
            dictionary[head] = True
            head = head.next
        return False
        

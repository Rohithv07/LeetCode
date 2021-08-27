# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def reverseKGroup(self, head: ListNode, k: int) -> ListNode:
        # Checking the availability to reverse 
        current = head
        for i in range(k):
            if not current:
                return head
            current = current.next
            
        # Basic Reverse in Linked List
        current = head
        previous = None
        for i in range(k):
            current_next = current.next
            current.next = previous
            previous = current 
            current = current_next
        
        # A recursive call to carry on with it.
        head.next = self.reverseKGroup(current, k)
        return previous
            
        

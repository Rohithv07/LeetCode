# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def reverseList(self, head: ListNode) -> ListNode:
        
        if head is None or head.next is None:
            return head
        
        current = head
        previous = None
        
        while current is not None:
            current_next = current.next
            current.next = previous
            previous = current
            current = current_next
            
        return previous
        
    

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def reverseList(self, head: ListNode, prev = None) -> ListNode:
        if head is None:
            return prev
        
        next_item = head.next
        head.next = prev
        return self.reverseList(next_item, head)
        
        
    

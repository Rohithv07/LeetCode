# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def removeElements(self, head: ListNode, val: int) -> ListNode:
        current = head
        previous = head
        
        while(current):
            if current.val == val:
                if current == head:
                    head = head.next
                else:
                    previous.next = current.next
                current = current.next
                
            else:
                previous = current
                current = current.next
            
        return head

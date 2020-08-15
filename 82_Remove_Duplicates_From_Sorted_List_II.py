# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def deleteDuplicates(self, head: ListNode) -> ListNode:
        if head == None or head.next == None:
            return head
        currentValue = head.val
        if (currentValue != head.next.val):
            head.next = self.deleteDuplicates(head.next)
            return head
        
        while(head and head.val == currentValue):
            head = head.next
            
        return self.deleteDuplicates(head)

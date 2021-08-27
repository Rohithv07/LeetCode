# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def reorderList(self, head: ListNode) -> None:
        """
        Do not return anything, modify head in-place instead.
        """
        if not head:
            return head
        slow = head
        fast = head
        while fast != None and fast.next != None:
            slow = slow.next
            fast = fast.next.next
            
        node1 = head
        reverseSlow = self.reverse(slow.next)
        slow.next = None
        while reverseSlow:
            node1.next, node1 = reverseSlow, node1.next
            reverseSlow.next, reverseSlow = node1, reverseSlow.next
            
    def reverse(self, node):
        current = node
        previous = None
        while current:
            currentNext = current.next
            current.next = previous
            previous = current
            current = currentNext
        return previous

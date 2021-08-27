# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def rotateRight(self, head: ListNode, k: int) -> ListNode:
        if head == None or head.next == None or k == 0:
            return head
        
        length = 1
        tail = head
        while(tail.next != None):
            length += 1
            tail = tail.next
        if k > length:
            k = k % length
        tail.next = head
        stepsToReachNewHead = length - k
        newTail = tail
        
        while(stepsToReachNewHead > 0):
            newTail =  newTail.next
            stepsToReachNewHead -= 1
            
        newHead = newTail.next
        newTail.next = None
        return newHead
        

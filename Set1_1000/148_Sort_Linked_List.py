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

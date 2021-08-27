# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def mergeTwoLists(self, l1: ListNode, l2: ListNode) -> ListNode:
        temp =ListNode(0)
        result = temp
        
        while True:
            if not l2:
                result.next = l1
                break
            if not l1:
                result.next = l2
                break
            if l1.val > l2.val:
                result.next = ListNode(l2.val)
                l2 = l2.next
            else:
                result.next =  ListNode(l1.val)
                l1 = l1.next
            result = result.next
        return temp.next
        

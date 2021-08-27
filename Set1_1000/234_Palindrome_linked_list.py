# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def isPalindrome(self, head: ListNode) -> bool:
        list = []
        while head:
            list.append(head.val)
            head = head.next
        return list == list[::-1]
        

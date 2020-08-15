# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def addTwoNumbers(self, l1: ListNode, l2: ListNode) -> ListNode:
        dummyNode = ListNode(0)
        l3 = dummyNode
        carry = 0
        
        while(l1 != None or l2 != None):
            if l1 != None:
                l1Value = l1.val
            else:
                l1Value = 0
            
            if l2 != None:
                l2Value = l2.val
            else:
                l2Value = 0
                
            currentSum = l1Value + l2Value + carry
            carry = currentSum // 10
            lastDigit = currentSum % 10
            
            newNode = ListNode(lastDigit)
            l3.next = newNode
            
            if l1 != None:
                l1 = l1.next
            if l2 != None:
                l2 = l2.next
            l3 = l3.next
                
        if carry > 0:
            newPlaceDigit = ListNode(carry)
            l3.next = newPlaceDigit
            l3 = l3.next
            
        return dummyNode.next
                
            
                

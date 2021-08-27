# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def detectCycle(self, head: ListNode) -> ListNode:
        """
        slow = head
        fast = head
        while(fast is not None and fast.next is not None):
            slow = slow.next
            fast = fast.next.next
            if slow == fast:
                slow = head
                while(slow != fast):
                    slow = slow.next
                    fast = fast.next
                return slow
        
        return None
        """
        dictionary = collections.defaultdict(ListNode)
        while(head):
            if head in dictionary:
                return head
            dictionary[head] = True
            head = head.next
        return None
                    

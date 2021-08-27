class Solution:
    def reverseList(self, head: ListNode) -> ListNode:
        if not head:
            return head
        first = head
        second = first.next
        while(second):
            temp = second.next
            second.next = first
            first = second
            second = temp
            
        head.next = None
        head = first
        return head

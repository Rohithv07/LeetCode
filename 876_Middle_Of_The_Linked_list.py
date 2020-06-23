class Solution:
    def middleNode(self, head: ListNode) -> ListNode:
        lower = head
        higher = head
        while(higher and  higher.next):
            lower = lower.next
            higher = higher.next.next
        
        return lower
        

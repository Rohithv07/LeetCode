# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def mergeInBetween(self, list1: ListNode, a: int, b: int, list2: ListNode) -> ListNode:
        start = None
        end = list1
        for i in range(b):
            if i == a - 1:
                start = end
            end = end.next
        start.next = list2
        while list2.next:
            list2 = list2.next
        list2.next = end.next
        end.next = None
        return list1
    
    """
    Here what we do mean, we just create 2 listnode -> start pointing to null and end pointing to list1
    What we actually need to do mean, from a to b, the elements inside the list1 is dropped and the elements of list2 is inserted there.
    Now after inserting, the next element must point to the next element after bth position
    So I first traversed from i = 0 to b:
        if our i become a-1, then from that point we need to insert list2 elements until the end
    So we set start.next as list2.
    Now we add all the elements inside the list2 and point the list2.next to the end where we need to continue with list1
    ie list2.next = end.next and set end.next as None as the remaining elements are already in list1
    SO a final list1 return will finsish the work
    """

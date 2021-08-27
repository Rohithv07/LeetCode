# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def sortedArrayToBST(self, nums: List[int]) -> TreeNode:
        def recursive(low, high):
            if low == high:
                return None
            middle = (low + high) // 2
            return TreeNode(nums[middle], recursive(low, middle), recursive(middle+1, high))
        return recursive(0, len(nums))
        

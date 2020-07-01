# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def minDepth(self, root: TreeNode) -> int:
        if not root:
            return 0
        
        left_val = self.minDepth(root.left)
        right_val = self.minDepth(root.right)
            #if left_val and right_val:
             #   return min(left_val, right_val) + 1
            #elif left_val:
             #   return left_val + 1
            #elif right_val:
             #   return right_val + 1
            #else:
             #   return 1
        return (min(left_val, right_val) or max(left_val, right_val)) + 1
            

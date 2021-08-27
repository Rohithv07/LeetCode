# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def sumOfLeftLeaves(self, root: TreeNode) -> int:
        def isLeaf(node):
            if not node:
                return False
            if node.left is None and node.right is None:
                return True
            return False
        
        result = 0
        
        if root is not None:
            if isLeaf(root.left):
                result += root.left.val
            else:
                result += self.sumOfLeftLeaves(root.left)
            
            result += self.sumOfLeftLeaves(root.right)
            
        return result
        

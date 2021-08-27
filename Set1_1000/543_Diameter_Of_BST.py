# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def diameterOfBinaryTree(self, root: TreeNode) -> int:
        if root is None:
            return 0
        
        left_height = self.height(root.left)
        right_height = self.height(root.right)
        
        left_dia = self.diameterOfBinaryTree(root.left)
        right_dia = self.diameterOfBinaryTree(root.right)
        
        return max((left_height + right_height), max(left_dia,right_dia))
    
    def height(self, node):
        if node is None:
            return 0
        return 1 + max(self.height(node.left), self.height(node.right))
        

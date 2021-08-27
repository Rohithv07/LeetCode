# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def invertTree(self, root: TreeNode) -> TreeNode:
        if root == None:
            return None
        Left = self.invertTree(root.left)
        Right = self.invertTree(root.right)
        root.left = Right
        root.right = Left
        return root

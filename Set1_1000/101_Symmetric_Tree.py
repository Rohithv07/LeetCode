# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def recursive(self, p, q):
        if p and q:
            return (p.val == q.val) and self.recursive(p.left, q.right) and self.recursive(p.right, q.left)
        elif p or q:
            return False
        return True
    def isSymmetric(self, root: TreeNode) -> bool:
        if not root:
            return True
        return self.recursive(root.left, root.right)

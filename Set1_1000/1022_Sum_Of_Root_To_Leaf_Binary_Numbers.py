# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def sumRootToLeaf(self, root: TreeNode) -> int:
        return self.dfsHelper(root, 0)
    def dfsHelper(self, node:TreeNode, total:int) -> int:
        total = total * 2 + node.val
        if (node.left == None and node.right == None):
            return total
        if (node.left == None):
            l = 0
        else:
            l = self.dfsHelper(node.left, total)
        if (node.right == None):
            r = 0
        else:
            r = self.dfsHelper(node.right, total)
        return l + r

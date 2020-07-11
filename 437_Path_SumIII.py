# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    counter = 0
    def pathSum(self, root: TreeNode, sum: int) -> int:
        def dfs(root, start, s):
            if not root:
                return
            
            s -= root.val
            if s == 0:
                self.counter += 1
            dfs(root.left, False, s)
            dfs(root.right, False, s)
            
            if start:
                dfs(root.left, True, sum)
                dfs(root.right, True, sum)
                
        dfs(root, True, sum)
        return self.counter
        

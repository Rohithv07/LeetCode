# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isSameTree(self, p: TreeNode, q: TreeNode) -> bool:
        
        # Solution 1:DFS
        def recursive(p, q):
            if p and q:
                return p.val == q.val and recursive(p.left, q.left) and recursive(p.right, q.right)
            elif p or q:
                return False
            return True
        return recursive(p, q)    
    
        # Solution 2:  
        if p == q == None:
            return True
        if(not p and q) or (p and not q):
            return False
        if (p.val != q.val):
            return False
        
        return self.isSameTree(p.left, q.left) and self.isSameTree(p.right, q.right)

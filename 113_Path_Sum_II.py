# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def pathSum(self, root: TreeNode, sum: int) -> List[List[int]]:
        
        def dfsRecursive(node, path, s):
            if not node:
                return 
            
            if s+node.val == sum and not node.left and not node.right:
                res.append(path+[node.val])
                
            if node.left:
                dfsRecursive(node.left, path+[node.val], s+node.val)
            if node.right:
                dfsRecursive(node.right, path+[node.val], s+node.val)
        res = []
        dfsRecursive(root, [], 0)
        return res

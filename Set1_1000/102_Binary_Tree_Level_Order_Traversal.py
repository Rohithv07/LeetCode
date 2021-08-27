# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
from collections import deque
class Solution:
    def levelOrder(self, root: TreeNode) -> List[List[int]]:
        res = []
        
        def dfsTraversal(node, layer, res):
            if not node:
                return
            if len(res) < layer+1: # For example, if you're at root, nothing has added to res and its length is zero. You add the [] to later add the number in in. This is true for other deeper layers. 
                res.append([])
                
            res[layer].append(node.val)
            dfsTraversal(node.left, layer + 1, res)
            dfsTraversal(node.right, layer + 1, res)
            
        dfsTraversal(root, 0, res)
        return res

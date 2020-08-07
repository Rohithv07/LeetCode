# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def verticalTraversal(self, root: TreeNode) -> List[List[int]]:
        dictionary = collections.defaultdict(list)
        
        def recursive(node, hd, layer):
            if not node:
                return 
            
            dictionary[hd].append((layer, node.val))
            
            recursive(node.left, hd - 1, layer + 1)
            recursive(node.right, hd + 1, layer + 1)
            
        recursive(root, 0, 0)
        return [[val for i, val in sorted(v)] for key, v in sorted(dictionary.items())]

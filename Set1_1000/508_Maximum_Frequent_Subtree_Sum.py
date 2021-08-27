# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def findFrequentTreeSum(self, root: TreeNode) -> List[int]:
        if not root:
            return []
        
        dictionary = collections.defaultdict(int)
        def dfs_call_sum(node):
            if not node:
                return 0
            
            left = dfs_call_sum(node.left)
            right = dfs_call_sum(node.right)
            sums = node.val + left + right
            dictionary[sums] += 1
            
            return sums
        
        dfs_call_sum(root)
        maximum = max(dictionary.values())
        result = [k for k, v in dictionary.items() if v == maximum]
        
        return result

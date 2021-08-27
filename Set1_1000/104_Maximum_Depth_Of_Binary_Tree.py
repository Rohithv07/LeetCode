class Solution:
    def maxDepth(self, root: TreeNode) -> int:
        if not root:
            return 0
        level = max(self.maxDepth(root.left), self.maxDepth(root.right))
        return level + 1

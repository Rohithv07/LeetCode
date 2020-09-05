# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def getAllElements(self, root1: TreeNode, root2: TreeNode) -> List[int]:
        def inOrderTraversal(node, array):
            if node is not None:
                inOrderTraversal(node.left, array)
                array.append(node.val)
                inOrderTraversal(node.right, array)
                
        root1List = []
        root2List = []
        inOrderTraversal(root1, root1List)
        inOrderTraversal(root2, root2List)
        root1List.extend(root2List)
        return sorted(root1List)

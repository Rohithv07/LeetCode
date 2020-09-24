/* My thoght process

Here the idea is straight forward, we can just convert our input binary search tree into a list and it can be done using a inorder traversal left -> root -> right.

After converting it will be inthe sorted order, so we need a root value and all the values less than root on the left of root and all the values greater than root on the right.

So we can find the middle of the list, assign it as root, and continue with the left and right part. Finally return the root.

Note: A binary search tree is balanced if and only if the depth of the two subtrees of every node never differ by more than 1.

*/


class Solution:
    def balanceBST(self, root: TreeNode) -> TreeNode:
        if root == None:
            return None
        arrayList = []
        def dfs(node):
            if not node:
                return
            dfs(node.left)
            arrayList.append(node.val)
            dfs(node.right)
        def create(arrayList):
            if not arrayList:
                return
            middle = len(arrayList) // 2
            newRoot = TreeNode(arrayList[middle])
            newRoot.left = create(arrayList[:middle])
            newRoot.right = create(arrayList[middle+1:])
            
            return newRoot
        dfs(root)
        return create(arrayList)

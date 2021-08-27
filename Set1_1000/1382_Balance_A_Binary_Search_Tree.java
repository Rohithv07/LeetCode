/* My thoght process

Here the idea is straight forward, we can just convert our input binary search tree into a list and it can be done using a inorder traversal left -> root -> right.

After converting it will be inthe sorted order, so we need a root value and all the values less than root on the left of root and all the values greater than root on the right.

So we can find the middle of the list, assign it as root, and continue with the left and right part. Finally return the root.

Note: A binary search tree is balanced if and only if the depth of the two subtrees of every node never differ by more than 1.

*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    List<TreeNode> list = new ArrayList<>();
    public TreeNode balanceBST(TreeNode root) {
        if (root == null)
            return null;
        inOrder(root);
        return balanced(0, list.size()-1);
    }
    public void inOrder(TreeNode node) {
        if (node == null)
            return;
        inOrder(node.left);
        list.add(node);
        inOrder(node.right);
    }
    public TreeNode balanced(int start, int end) {
        if (start > end)
            return null;
        int middle = (start + end) / 2;
        TreeNode newRoot = list.get(middle);
        newRoot.left = balanced(start, middle-1);
        newRoot.right = balanced(middle+1, end);
        return newRoot;
    }
}

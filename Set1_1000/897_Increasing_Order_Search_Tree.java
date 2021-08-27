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
    public TreeNode increasingBST(TreeNode root) {
        if (root == null)
            return null;
        List<Integer> list = new ArrayList<>();
        inorder(root, list);
        TreeNode finalAnswer = new TreeNode(0);
        TreeNode current = finalAnswer;
        for(int values: list) {
            current.right = new TreeNode(values);
            current = current.right;
        }
        return finalAnswer.right;
    }
    public void inorder(TreeNode node, List<Integer> list) {
        if (node == null)
            return;
        inorder(node.left, list);
        list.add(node.val);
        inorder(node.right, list);
    }
}

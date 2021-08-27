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

// take only one node from the tree from each depth. ALways take from the right if possible, otherwise change according to the availablity
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null)
            return new ArrayList<>();
        List<Integer> rightSide = new ArrayList<>();
        showRightSideView(rightSide, root, 0);
        return rightSide;
    }
    public void showRightSideView(List<Integer> rightSide, TreeNode node, int depth) {
        if (node == null)
            return;
        if (depth == rightSide.size()) {
            rightSide.add(node.val);
        }
        showRightSideView(rightSide, node.right, depth + 1);
        showRightSideView(rightSide, node.left, depth + 1);
    }
}

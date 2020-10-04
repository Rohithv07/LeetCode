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
    public boolean isEvenOddTree(TreeNode root) {
        if (root == null)
            return false;
        Queue<TreeNode> queue = new LinkedList<>();
        int level = 0;
        int previous = 0;
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i=0; i<size; i++) {
                TreeNode current = queue.poll();
                if (level % 2 == 0) {
                    if (current.val % 2  == 0)
                        return false;
                    if (i > 0 && current.val <= previous)
                        return false;
                    previous = current.val;
                }
                else {
                    if (current.val % 2 != 0)
                        return false;
                    if (i > 0  && current.val >= previous)
                        return false;
                    previous = current.val;
                }
                if (current.left != null)
                    queue.add(current.left);
                if (current.right != null)
                    queue.add(current.right);
            }
            level += 1;
        }
        return true;
    }
}

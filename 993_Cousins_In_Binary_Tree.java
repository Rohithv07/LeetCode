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
    public boolean isCousins(TreeNode root, int A, int B) {
        if (root == null)
            return false;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            boolean isAInSameLevel = false;
            boolean isBInSameLevel = false;
            int size = queue.size();
            for (int i=0; i<size; i++) {
                TreeNode current = queue.poll();
                if (current.val == A)
                    isAInSameLevel = true;
                if (current.val == B)
                    isBInSameLevel = true;
                if (current.left != null && current.right != null) {
                    // same parent
                    if (current.left.val == A && current.right.val == B) 
                        return false;
                    if (current.left.val == B && current.right.val == A)
                        return false;
                }
                if (current.left != null)
                    queue.add(current.left);
                if (current.right != null)
                    queue.add(current.right);
            }
            if (isAInSameLevel && isBInSameLevel)
                return true;
            else if (isAInSameLevel || isBInSameLevel)
                return false;
        }
        return false;
    }
}

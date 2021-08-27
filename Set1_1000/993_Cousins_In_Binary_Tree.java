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
    private int leftDepth = -1;
    private int rightDepth = -2;
    // because the depth should not be equal
    private TreeNode leftParent = null;
    private TreeNode rightParent = null;
    public boolean isCousins(TreeNode root, int x, int y) {
        if (root == null)
            return false;
        dfsHelper(root, null, x, y, 0);
        return leftDepth == rightDepth && leftParent != rightParent;
    }
    
    public void dfsHelper(TreeNode node, TreeNode parent, int x, int y, int depth) {
        if (node == null)
            return;
        if (node.val == x) {
            leftParent = parent;
            leftDepth = depth;
        }
        else if (node.val == y) {
            rightParent = parent;
            rightDepth = depth;
        }
        else {
            // check for left and right subtree
            dfsHelper(node.left, node, x, y, depth + 1);
            dfsHelper(node.right, node, x, y, depth + 1);
        }
    }
}

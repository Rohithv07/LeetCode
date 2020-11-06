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
class FindElements {
    private Set<Integer> set;
    public FindElements(TreeNode root) {
        set = new HashSet<>();
        root.val = 0;
        set.add(root.val);
        recoverTree(root);
    }
    public void recoverTree(TreeNode root) {
        if (root == null)
            return;
        if (root.left != null) {
            int leftValue = 2 * root.val + 1;
            root.left.val = leftValue;
            set.add(leftValue);
        }
        if (root.right != null) {
            int rightValue = 2 * root.val + 2;
            root.right.val = rightValue;
            set.add(rightValue);
        }
        recoverTree(root.left);
        recoverTree(root.right);
    }
    
    public boolean find(int target) {
        return set.contains(target);
    }
}

/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */

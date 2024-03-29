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
    public int rob(TreeNode root) {
        int [] storeTheMoney = dfs(root);
        return Math.max(storeTheMoney[0], storeTheMoney[1]);
    }
    public int [] dfs(TreeNode node) {
        if (node == null)
            return new int [2];
        // store the left childs
        int [] left = dfs(node.left);
        // store the right childs
        int [] right = dfs(node.right);
        int [] storeTheMoney = new int [2];
        
        storeTheMoney[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        storeTheMoney[1] = node.val + left[0] + right[0];
        return storeTheMoney;
    }
}

// refer : https://leetcode.com/problems/house-robber-iii/discuss/79330/Step-by-step-tackling-of-the-problem


// same problem way using video solving

// https://www.youtube.com/watch?v=nHR8ytpzz7c

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
    public int rob(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int [] withAndWithoutRoot = postOrder(root);
        return Math.max(withAndWithoutRoot[0], withAndWithoutRoot[1]);
    }
    
    // [withroot, withoutroot]
    public int [] postOrder(TreeNode node) {
        if (node == null) {
            return new int []{0, 0};
        }
        int [] leftChild = postOrder(node.left);
        int [] rightChild = postOrder(node.right);
        int withRoot = node.val + leftChild[1] + rightChild[1];
        int withOutRoot = Math.max(leftChild[0], leftChild[1]) + Math.max(rightChild[0], rightChild[1]);
        return new int []{withRoot, withOutRoot};
    }
}
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
// we start from the root and initially let the parent be null and grandparent be null
// perform the dfs using a helper function
// if we see the grandparent != null and its value as even, increment the sum with current value
// else do dfs to the left and updating the current node as the parent and the parent as the grandparent
class Solution {
    public int sumEvenGrandparent(TreeNode root) {
        if (root == null)
            return 0;
        return dfsHelper(root, null, null);  // (currentNode, parentNode, grandparentNode);
    }
    public int dfsHelper(TreeNode currentNode, TreeNode parentNode, TreeNode grandParentNode) {
        int sum = 0;
        if (currentNode == null)
            return 0;
        if (grandParentNode!=null && grandParentNode.val%2 == 0)
            sum += currentNode.val;
        sum += dfsHelper(currentNode.left, currentNode, parentNode);
        sum += dfsHelper(currentNode.right, currentNode, parentNode);
        return sum;
    }
}

// time complexity O(depthOfTree)

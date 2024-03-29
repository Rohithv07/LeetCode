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

/*

This is a clean and smart solution, my understanding is as follows:

A fully completed tree has node number: count = 2 ^ depth - 1
for example: [1,2,3]
depth is 2
count = 2 ^ 2 - 1 = 3
Compare left height and right height, if equal, use the formular, otherwise recurvisely search left and right at next level
The search pattern is very similar to binary search, the difference of heights ethier exsits in left side, or right side
Due to the reason stated in point 3, the time complexity is h ^ 2, there is h times for each level, and h times for calculating height at each level

here the complexity will be O(logn * logn)
*/



class Solution {
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = findLeftDepth(root);
        int rightDepth = findRightDepth(root);
        if (leftDepth == rightDepth) {
            return (1 << leftDepth) - 1;
        }
        return 1 + countNodes(root.left) + countNodes(root.right);
    }
    
    public int findLeftDepth(TreeNode node) {
        int leftDepth = 0;
        while (node != null) {
            node = node.left;
            leftDepth++;
        }
        return leftDepth;
    }
    
    public int findRightDepth(TreeNode node) {
        int rightDepth = 0;
        while (node != null) {
            node = node.right;
            rightDepth++;
        }
        return rightDepth;
    }
}


// brute force approach


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
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int [] count = new int [1];
        inorder(root, count);
        return count[0];
    }
    
    public void inorder(TreeNode node, int [] count) {
        if (node == null) {
            return;
        }
        inorder(node.left, count);
        count[0] += 1;
        inorder(node.right, count);
    }
}




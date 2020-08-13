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
    public TreeNode sortedArrayToBST(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        return convertToBST(nums, low, high);
    }
    public TreeNode convertToBST(int [] nums, int low, int high){
        if (low > high)
            return null;
        int middle = (low + high) / 2;
        TreeNode node = new TreeNode(nums[middle]);
        if (low == high)
            return node;
        node.left = convertToBST(nums, low, middle-1);
        node.right = convertToBST(nums, middle+1, high);
        return node;
    }
}

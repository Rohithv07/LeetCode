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
    public TreeNode createBinaryTree(int[][] descriptions) {
        if (descriptions == null || descriptions.length == 0) {
            return new TreeNode();
        }
        Set<Integer> trackChild = new HashSet<>();
        for (int [] desc : descriptions) {
            trackChild.add(desc[1]);
        }
        Map<Integer, TreeNode> parentChildMapping = new HashMap<>();
        // we need to find the root
        int rootElement = getRootElement(descriptions, trackChild);
        for (int [] des : descriptions) {
            int parent = des[0];
            int child = des[1];
            int leftOrRight = des[2];
            TreeNode node = parentChildMapping.getOrDefault(parent, new TreeNode(parent));
            if (leftOrRight == 1) {
                node.left = parentChildMapping.getOrDefault(child, new TreeNode(child));
                parentChildMapping.put(child, node.left);
            }
            else {
                node.right = parentChildMapping.getOrDefault(child, new TreeNode(child));
                parentChildMapping.put(child, node.right);
            }
            parentChildMapping.put(parent, node);
        }
        return parentChildMapping.getOrDefault(rootElement, null);
    }
    
    public int getRootElement(int [][] descriptions, Set<Integer> trackChild) {
        int rootElement = -1;
        for (int [] desc : descriptions) {
            if (!trackChild.contains(desc[0])) {
                rootElement = desc[0];
                break;
            }
        }
        return rootElement;
    }
}
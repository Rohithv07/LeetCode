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

// here the first element of the preorder is the root and we find the root in the inorder
// all the element to the left of the root will be the left child and to the right is the right child
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0)
            return null;
        int root = preorder[0];
        TreeNode tree = new TreeNode(root);
        int getRootIndexFromInorder = -1;
        for (int i=0; i<inorder.length; i++) {
            if (root == inorder[i]) {
                getRootIndexFromInorder = i;
                break;
            }
        }
        // copy all the elements to the left as left child and right as right child
        int [] leftChildIn = Arrays.copyOfRange(inorder, 0, getRootIndexFromInorder);
        int [] rightChildIn = Arrays.copyOfRange(inorder, getRootIndexFromInorder+1, inorder.length);
        int [] leftChildPre = Arrays.copyOfRange(preorder, 1, getRootIndexFromInorder+1);
        int [] rightChildPre = Arrays.copyOfRange(preorder, getRootIndexFromInorder+1, preorder.length);
        
        tree.left = buildTree(leftChildPre, leftChildIn);
        tree.right = buildTree(rightChildPre, rightChildIn);
        return tree;
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
    private int pre = 0;
    private int in = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return construct(preorder, inorder, Integer.MIN_VALUE);
    }
    
    public TreeNode construct(int [] preorder, int [] inorder, int stop) {
        if (pre >= preorder.length)
            return null;
        if (inorder[in] == stop) {
            in++;
            return null;
        }
        TreeNode node = new TreeNode(preorder[pre++]);
        node.left = construct(preorder, inorder, node.val);
        node.right = construct(preorder, inorder, stop);
        
        return node;
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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0 || inorder == null || inorder.length == 0) {
            return null;
        }
        return constructTree(0, 0, inorder.length - 1, preorder, inorder);
    }
    
    public TreeNode constructTree(int preIndex, int inStart, int inEnd, int [] preorder, int [] inorder) {
        if (preIndex >= preorder.length || inStart > inEnd) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preIndex]);
        int rootInInorder = -1;
        for (int i=inStart; i<=inEnd; i++) {
            if (preorder[preIndex] == inorder[i]) {
                rootInInorder = i;
                break;
            }
        }
        root.left = constructTree(preIndex+1, inStart, rootInInorder - 1, preorder, inorder);
        root.right = constructTree(preIndex + rootInInorder - inStart + 1, rootInInorder + 1, inEnd, preorder, inorder);
        return root;
    }
}

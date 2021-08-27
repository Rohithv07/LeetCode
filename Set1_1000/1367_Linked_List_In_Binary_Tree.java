/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
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
    List<TreeNode> storingList = new ArrayList();
    public boolean isSubPath(ListNode head, TreeNode root) {
        storeToList(head, root);
        for (TreeNode element: storingList){
            if (checkSubPath(head, element))
                return true;
        }
        return false;
    }
    public void storeToList(ListNode head, TreeNode node){
        if (head == null || node == null)
            return;
        if (head.val == node.val)
            storingList.add(node);
        storeToList(head, node.left);
        storeToList(head, node.right);
    }
    public boolean checkSubPath(ListNode head, TreeNode node){
        if (head == null)
            return true;
        if (node == null)
            return false;
        if (head.val == node.val)
            return (checkSubPath(head.next, node.left) || checkSubPath(head.next, node.right));
        return false;
    }
}

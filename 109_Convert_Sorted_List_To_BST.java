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
    public TreeNode sortedListToBST(ListNode head) {
        List<Integer> array = new ArrayList();
        while(head != null){
            array.add(head.val);
            head = head.next;
        }
        int low = 0;
        int high = array.size() - 1;
        return convertSortedList(array,low, high);
    }
    public TreeNode convertSortedList(List<Integer> array,int low, int high){
        if (low > high)
            return null;
        int middle = (low + high) / 2;
        TreeNode node = new TreeNode(array.get(middle));
        if (low == high)
            return node;
        node.left = convertSortedList(array, low, middle-1);
        node.right = convertSortedList(array, middle+1, high);
        return node;
    }
}

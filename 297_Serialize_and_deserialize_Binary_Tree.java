/* 
My thought process :
So we are given a binary tree, we need to first serialise it into a string. Then deserialize which means to bring back the tree from string.

So serialise is quite is easy. We can initialy check whether the root is null, if yes return "X"/
Otherwise we can get left by doing recursion(root.left) and right by doing recursion(root.right)
Now we can concatenate the root.val, ',', left, ', ', right. Here we go on with preorder traversal as its the format in output.

Now deserialise is quite a tricky one because we need to have a look on the progress or on which string we are carrying on. So if we look throught the string, we have root, left, right actually if we deserialise the string, so its like people standing on the queue waiting for its turn. So we can make use of queue here.
We add all the string values into the queue after splitting by ','
Now we uses a helperfunction which returns the treenode what we want.

Now Inside the helper function, we take the front value, then initially checks whether its X bcause if X we can directly return null.
Now we can have a node of type treenode converting the string into a interger value. Now we do recursion as
            node.left = recursion(queue)
            node.right = recursion(queue)
            
            return node.
            
Thats the whole problem .

*/




/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        // We do a preorder traversal
        if (root == null)
            return "X";
        String left = serialize(root.left);
        String right = serialize(root.right);
        StringBuilder sb = new StringBuilder();
        sb.append(root.val);
        sb.append(",");
        sb.append(left);
        sb.append(",");
        sb.append(right);
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        // We can make use of a queue here
        Queue<String> queue = new LinkedList<>();
        queue.addAll(Arrays.asList(data.split(",")));
        return helper(queue);
    }
    public TreeNode helper(Queue<String> queue) {
        String value = queue.poll();
        if (value.equals("X"))
            return null;
        TreeNode newNode = new TreeNode(Integer.valueOf(value));
        newNode.left = helper(queue);
        newNode.right = helper(queue);
        return newNode;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));

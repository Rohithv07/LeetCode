/*
Using stack, this is the idea
// case 1: we see a number, just push it to the stack
        // case 2: we see #, check if the top of stack is also #
        // if so, pop #, pop the number in a while loop, until top of stack is not #
        // if not, push it to stack
        // in the end, check if stack size is 1, and stack top is #
*/

class Solution {
    public boolean isValidSerialization(String preorder) {
        if (preorder == null || preorder.length() == 0)
            return false;
        String [] root = preorder.split(",");
        /*
        all non-null node provides 2 outdegree and 1 indegree (2 children and 1 parent), except root
        all null node provides 0 outdegree and 1 indegree (0 child and 1 parent).
        */
        int diff = 1;
        for (String node : root) {
            if (--diff < 0)
                return false;
            if (!node.equals("#"))
                diff += 2;
        }
        return diff == 0;
    }
}
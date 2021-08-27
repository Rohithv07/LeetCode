/*
The idea : 
    For all possible values of i, consider i as root, then [1….i-1] numbers will fall in the left subtree and [i+1….n] numbers will fall in the right subtree. So, add (i-1)*(n-i) to the answer. The summation of the products will be the answer to the number of unique BST.

*/

class Solution {
    public int numTrees(int n) {
        // create the dp array of size n+1
        int [] dp = new int [n+1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i=2; i<=n; i++) {
            for (int j=1; j<=i; j++) {
                // j-1 on left * n-i on right + dp[i]
                dp[i] = dp[i] + (dp[i-j] * dp[j-1]);
            }
        }
        return dp[n];
    }
}

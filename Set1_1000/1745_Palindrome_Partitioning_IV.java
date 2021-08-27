class Solution {
    public boolean checkPartitioning(String s) {
        int n = s.length();
        boolean [][] dp = new boolean [n][n];
        for (int i=n-1; i>=0; i--) {
            for (int j=0; j<n; j++) {
                if (i >= j)
                    dp[i][j] = true;
                else if (s.charAt(i) == s.charAt(j))
                    dp[i][j] = dp[i+1][j-1];
            }
        }
        for (int i=1; i<n; i++) {
            for (int j=i+1; j<n; j++) {
                    // left       // middle   // right
                if (dp[0][i-1] && dp[i][j - 1] && dp[j][n-1])
                    return true;
            }
        }
        return false;
    }
}
